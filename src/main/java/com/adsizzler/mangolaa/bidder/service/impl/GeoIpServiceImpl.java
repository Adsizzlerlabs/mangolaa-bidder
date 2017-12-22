package com.adsizzler.mangolaa.bidder.service.impl;

import com.adsizzler.mangolaa.bidder.service.GeoIpService;
import com.adsizzler.mangolaa.bidder.util.PreConditions;
import com.adsizzler.mangolaa.bidder.util.Strings;
import in.ankushs.dbip.api.DbIpClient;
import in.ankushs.dbip.api.GeoEntity;
import io.vertx.core.Future;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ankushsharma on 26/09/17.
 */
@Service
@Slf4j
public class GeoIpServiceImpl implements GeoIpService {

    private static final ExecutorService executor;

    static{
        log.info("Initializing {} thread pool with {} threads", GeoIpServiceImpl.class.getName(), 1);
        executor = Executors.newSingleThreadExecutor();
    }


    private final DbIpClient dbIpClient;

    public GeoIpServiceImpl(final DbIpClient dbIpClient){
        this.dbIpClient = dbIpClient;
    }

    @PreDestroy
    void cleanup(){
        log.info("Closing {} ExecutorService", GeoIpServiceImpl.class.getName());
        executor.shutdown();
        log.info("{} ExecutorService closed ? {} ", executor.isShutdown());
    }

    @Override
    public GeoEntity lookup(final String ip) {
        PreConditions.notNull(ip,"ip cannot be null");
        GeoEntity geoEntity;
        if(!Strings.hasText(ip)){
             geoEntity = dummy();
        }
        else{
             geoEntity = dbIpClient.lookup(ip);
        }
        return geoEntity;
    }

    @Override
    public Future<GeoEntity> lookupAsync(final String ip) {
        val future = Future.<GeoEntity>future();
        executor.execute( () -> {
            future.complete(lookup(ip));
        });
        return future;
    }


    private static final String UNKNOWN = "Unknown";

    private static GeoEntity dummy(){

        return new GeoEntity
                .Builder()
                .withCity(UNKNOWN)
                .withCity(UNKNOWN)
                .withCountryCode(UNKNOWN)
                .withIsp(UNKNOWN)
                .withProvince(UNKNOWN)
                .build();
    }
}
