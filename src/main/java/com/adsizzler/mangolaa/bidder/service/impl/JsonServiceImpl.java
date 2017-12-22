package com.adsizzler.mangolaa.bidder.service.impl;

import com.adsizzler.mangolaa.bidder.service.JsonService;
import com.adsizzler.mangolaa.bidder.util.Json;
import com.adsizzler.mangolaa.bidder.util.PreConditions;
import com.adsizzler.mangolaa.bidder.util.Strings;
import io.vertx.core.Future;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ankushsharma on 12/09/17.
 */
@Service
@Slf4j
public class JsonServiceImpl implements JsonService {

    private static final ExecutorService executor;

    static{
        log.info("Initializing {} thread pool with 1 thread", JsonServiceImpl.class.getName());
        executor = Executors.newSingleThreadExecutor();
    }

    @PreDestroy
    void cleanup(){
        log.info("Closing JsonService ExecutorService");
        executor.shutdown();
        log.info("JsonService ExecutorService closed ? {} ", executor.isShutdown());
    }

    @Override
    public <T> Future<T> toObject(
            final String json,
            final Class<T> clazz
    )
    {
        PreConditions.notNull(json,"json string cannot be null");
        PreConditions.notNull(clazz,"clazz cannot be null");
        val future = Future.<T>future();
        executor.execute( () -> {
            try{
                if(Strings.hasText(json)){
                    future.complete(Json.toObject(json,clazz));
                }
                else{
                    future.complete(null);
                }
            }
            catch(final Exception ex){
                future.fail(ex);
            }
        });
        return future;
    }

    @Override
    public <T> Future<String> toJson(final T object)
    {
        PreConditions.notNull(object,"object cannot be null");
        val future = Future.<String>future();
        executor.execute( () -> {
            try{
                future.complete(Json.toJson(object));
            }
            catch(final Exception ex){
                future.fail(ex);
            }
        });
        return future;
    }

    @Override
    public <T> Future<String> toPrettyJson(final T object)
    {
        PreConditions.notNull(object,"object cannot be null");
        val future = Future.<String>future();
        executor.execute( () -> {
            try{
                future.complete(Json.toPrettyJson(object));
            }
            catch(final Exception ex){
                future.fail(ex);
            }
        });
        return future;

    }

}
