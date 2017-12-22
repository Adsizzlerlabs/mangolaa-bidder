package com.adsizzler.mangolaa.bidder.config

import com.adsizzler.mangolaa.bidder.util.EnvironmentUtil
import io.vertx.core.Vertx
import io.vertx.kafka.client.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.ByteArraySerializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by Ankush on 13/04/17.
 */
@Configuration
class KafkaProducerConfig {

    @Autowired
    Vertx vertx

    @Autowired
    EnvironmentUtil env

    @Bean("kafka")
    KafkaProducer<String,byte[]> kafkaConsumer(){
        Properties config = new Properties();
        String host
        if(env.isDev() || env.isTest()){
            host = "localhost:9092"
        }
        else{
            host = "192.168.157.227:9092"
        }
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,host)
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class)
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class)
        config.put(ProducerConfig.ACKS_CONFIG, "1")
        config.put(ProducerConfig.BATCH_SIZE_CONFIG,"1000000")
        config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, "635544320")


        return KafkaProducer
                .create(vertx, config)
    }

}
