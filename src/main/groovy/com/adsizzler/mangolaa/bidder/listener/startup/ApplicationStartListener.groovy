package com.adsizzler.mangolaa.bidder.listener.startup

import groovy.util.logging.Slf4j
import io.vertx.kafka.client.producer.KafkaProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

/**
 * Created by ankushsharma on 17/10/17.
 */
@Component
@Slf4j
class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    KafkaProducer<String,byte[]> kafka

    @Override
    void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
