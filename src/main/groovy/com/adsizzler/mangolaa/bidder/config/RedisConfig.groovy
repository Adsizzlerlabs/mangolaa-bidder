package com.adsizzler.mangolaa.bidder.config

import com.adsizzler.mangolaa.bidder.util.EnvironmentUtil
import com.lambdaworks.redis.RedisClient
import com.lambdaworks.redis.RedisURI
import com.lambdaworks.redis.api.StatefulRedisConnection
import io.vertx.core.Vertx
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.util.concurrent.TimeUnit

/**
 * Created by ankushsharma on 04/09/17.
 */
@Configuration
class RedisConfig {

    @Autowired
    EnvironmentUtil env

    @Autowired
    Vertx vertx

    @Bean("lettuce")
    RedisClient lettuce(){
        def redis = RedisClient.create(
                RedisURI
                        .Builder
                        .socket("/tmp/redis.sock")
                        .withTimeout(1,TimeUnit.MILLISECONDS)
                .build()
        )
        redis
    }

    @Bean("redisConn")
    StatefulRedisConnection<String,String> redisConn(){
        lettuce().connect()
    }

}
