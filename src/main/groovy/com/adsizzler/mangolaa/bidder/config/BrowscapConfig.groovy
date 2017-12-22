package com.adsizzler.mangolaa.bidder.config

import com.adsizzler.mangolaa.bidder.util.EnvironmentUtil
import in.ankushs.browscap4j.domain.Browscap
import org.apache.commons.io.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader

/**
 * Created by ankushsharma on 09/10/17.
 */
@Configuration
class BrowscapConfig {

    @Autowired
    ResourceLoader resourceLoader

    @Autowired
    EnvironmentUtil env

    @Bean
    Browscap browscap(){
        def originalFileLocation
        def targetFileLocation
        if(env.isDev() || env.isTest()){
            originalFileLocation = "classpath:/dummy-browscap.csv"
            targetFileLocation = "classpath:/dummy-geoipTARGET.csv"
        }
        else{
            originalFileLocation = "classpath:/browscap.csv"
            targetFileLocation = "classpath:/browscapTARGET.csv"
        }
        def is = resourceLoader.getResource(originalFileLocation).getInputStream()
        String targetFile = resourceLoader.getResource(targetFileLocation).getFilename()
        def file = new File(targetFile)
        FileUtils.copyInputStreamToFile(is, file)
        new Browscap(file)

    }
}
