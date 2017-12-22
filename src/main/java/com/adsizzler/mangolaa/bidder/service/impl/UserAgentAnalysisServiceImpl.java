package com.adsizzler.mangolaa.bidder.service.impl;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.DeviceType;
import com.adsizzler.mangolaa.bidder.service.UserAgentAnalysisService;
import com.adsizzler.mangolaa.bidder.util.Strings;
import in.ankushs.browscap4j.domain.Browscap;
import in.ankushs.browscap4j.domain.BrowserCapabilities;
import io.vertx.core.Future;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.adsizzler.mangolaa.bidder.domain.openrtb.enums.DeviceType.*;

/**
 * Created by ankushsharma on 09/10/17.
 */
@Service
@Slf4j
public class UserAgentAnalysisServiceImpl implements UserAgentAnalysisService {

    private static final ExecutorService executor;

    static{
        val threads = 2;
        log.info("Initializing {} thread pool with {} threads", UserAgentAnalysisServiceImpl.class.getName(), threads);
        executor = Executors.newFixedThreadPool(threads);
    }

    private final Browscap browscap;

    public UserAgentAnalysisServiceImpl(final Browscap browscap){
        this.browscap = browscap;
    }

    @PreDestroy
    void cleanup(){
        log.info("Closing UserAgentAnalysisServiceImpl ExecutorService");
        executor.shutdown();
        log.info("UserAgentAnalysisServiceImpl ExecutorService closed ? {} ", executor.isShutdown());
    }

    @Override
    public UserAgentDetails getDetails(final String userAgent) throws Exception
    {
        UserAgentDetails userAgentDetails;
        if(!Strings.hasText(userAgent)){
            userAgentDetails = dummy();
        }
        else{
            val browserCapabilities = browscap.lookup(userAgent);
            userAgentDetails = UserAgentDetails
                            .builder()
                            .osVer(UNKNOWN)
                            .os(UNKNOWN)
                            .deviceType(getDeviceType(browserCapabilities.getDeviceType()))
                            .modelVer(browserCapabilities.getPlatformVersion())
                            .model(browserCapabilities.getPlatform())
                            .make(browserCapabilities.getDeviceBrandName())
                            .build();
        }
        return userAgentDetails;
    }


    @Override
    public Future<UserAgentDetails> getDetailsAsync(final String userAgent)
    {
        val future = Future.<UserAgentDetails>future();
        if(!Strings.hasText(userAgent)){
            future.complete(dummy());
        }
        else{
            executor.execute( () -> {
                BrowserCapabilities browserCapabilities = null;
                try {
                    browserCapabilities = browscap.lookup(userAgent);
                } catch (final Exception e) {
                   future.complete(dummy());
                }
                future.complete(
                        UserAgentDetails
                                .builder()
                                .osVer(UNKNOWN)
                                .os(UNKNOWN)
                                .deviceType(getDeviceType(browserCapabilities.getDeviceType()))
                                .modelVer(browserCapabilities.getPlatformVersion())
                                .model(browserCapabilities.getPlatform())
                                .make(browserCapabilities.getDeviceBrandName())
                                .build()
                );
            });
        }
        return future;
    }

    private static final String UNKNOWN = "";

    private static UserAgentDetails dummy(){
        return UserAgentDetails
                .builder()
                .make(UNKNOWN)
                .model(UNKNOWN)
                .modelVer(UNKNOWN)
                .deviceType(DeviceType.UNKNOWN)
                .os(UNKNOWN)
                .osVer(UNKNOWN)
                .build();
    }

    //Refer to https://github.com/browscap/browscap/wiki/Resource:-User-Agents-Database
    //Check under the title Device_Type to get list of Device type that Browscap provides
    private static DeviceType getDeviceType(final String deviceType){
        DeviceType result = DeviceType.UNKNOWN;
        if(Strings.hasText(deviceType)){
            switch(deviceType){
                case "Tablet":
                    result = TABLET;
                    break;
                case "FonePad":
                case "Mobile Device":
                case "Mobile Phone" :
                    result = MOBILE_TABLET;
                    break;
                case "Desktop":
                    result = PERSONAL_COMPUTER;
                    break;
                case "TV Device":
                    result = TV;
                    break;

                default : result = DeviceType.UNKNOWN;
            }
        }
        return result;
    }


    @Builder
    @Data
    public static class UserAgentDetails {

        private final String make;
        private final String model;
        private final String modelVer;
        private final DeviceType deviceType;
        private final String os;
        private final String osVer;

    }
}
