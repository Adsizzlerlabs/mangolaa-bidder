package com.adsizzler.mangolaa.bidder.config

import com.adsizzler.mangolaa.bidder.util.EnvironmentUtil
import in.ankushs.dbip.api.DbIpClient
import org.apache.commons.io.FileUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader

/**
 * Created by Ankush on 24/03/17.
 */
@Configuration
class GeoIpConfig {

    @Autowired
    ResourceLoader resourceLoader

    @Autowired
    EnvironmentUtil env

    @Bean(name="dbIpClient")
     DbIpClient getDbIpClient() throws IOException{
        def originalFileLocation
        def targetFileLocation
        if(env.isDev() || env.isTest()){
            originalFileLocation = "classpath:/dummy-geoip.csv.gz"
            targetFileLocation = "classpath:/dummy-geoipTARGET.csv.gz"
        }
        else{
            originalFileLocation = "classpath:/dbip-full-2017-09.csv.gz"
            targetFileLocation = "classpath:/dbip-full-2017-09TARGET.csv.gz"
        }
        def is = resourceLoader.getResource(originalFileLocation).getInputStream()
        String targetFile = resourceLoader.getResource(targetFileLocation).getFilename()
        def file = new File(targetFile)
        FileUtils.copyInputStreamToFile(is, file)
        new DbIpClient(file)
    }

}
