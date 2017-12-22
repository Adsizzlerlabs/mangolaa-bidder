package com.adsizzler.mangolaa.bidder.listener.stop

import com.lambdaworks.redis.RedisClient
import com.lambdaworks.redis.api.StatefulRedisConnection
import groovy.util.logging.Slf4j
import io.vertx.kafka.client.producer.KafkaProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextClosedEvent
import org.springframework.stereotype.Component

/**
 * Created by ankushsharma on 04/09/17.
 */
@Component
@Slf4j
class ApplicationStopListener implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    KafkaProducer<String,byte[]> kafka

    @Autowired
    StatefulRedisConnection<String,String> redisConn

    @Autowired
    RedisClient lettuce

    @Override
    void onApplicationEvent(ContextClosedEvent event) {
        try{
            log.info 'Closing down lettuce'
            redisConn.close()
            lettuce.shutdown()
            log.info 'Lettuce successfully closed'
        }
        catch(ex){
            log.error ex.toString()
        }

        kafka.close{ closed ->
            if(closed.succeeded()){
                log.info 'Closed connection with Kafka successfully'
            }
            else{
                log.info 'Could not close Kafka connection {}', closed.cause().message
            }
        }
    }
}
