package com.adsizzler.mangolaa.bidder.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by ankushsharma on 04/09/17.
 */
@Component
public class EnvironmentUtil{

    @Autowired
    private Environment environment;

    public boolean isProduction(){
        return !(isDev() || isTest());
    }

    public boolean isDev(){
        return Arrays.asList(environment.getActiveProfiles()).contains("dev");
    }

    public boolean isTest(){
        return Arrays.asList(environment.getActiveProfiles()).contains("test");
    }


}