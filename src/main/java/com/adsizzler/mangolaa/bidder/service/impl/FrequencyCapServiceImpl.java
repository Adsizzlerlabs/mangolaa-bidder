package com.adsizzler.mangolaa.bidder.service.impl;

import com.adsizzler.mangolaa.bidder.domain.Campaign;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.User;
import com.adsizzler.mangolaa.bidder.service.FrequencyCapService;
import com.adsizzler.mangolaa.bidder.service.ImpressionCountService;
import com.adsizzler.mangolaa.bidder.util.PreConditions;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by ankushsharma on 03/10/17.
 */
@Service
@Slf4j
public class FrequencyCapServiceImpl implements FrequencyCapService {

    private final ImpressionCountService impressionCountService;

    public FrequencyCapServiceImpl(final ImpressionCountService impressionCountService){
        this.impressionCountService = impressionCountService;
    }

    @Override
    public Future<Boolean> capReached(
            final User user,
            final Campaign campaign
    )
    {
        PreConditions.notNull(campaign,"campaign cannot be null");

        val cappings = campaign.getCappings();
        PreConditions.notNull(cappings,"capping cannot be null");

        val future = Future.<Boolean>future();
        val campaignId = campaign.getId();

        if(Objects.isNull(user)){
            future.complete(false);
        }
        else{
            val dailyCountFuture = impressionCountService.getDailyCount(user,campaignId);
            val totalCountFuture = impressionCountService.getTotalCount(user,campaignId);


            CompositeFuture.all(dailyCountFuture,totalCountFuture)
                    .setHandler( ar -> {
                        if(ar.succeeded()){
                            val values = ar.result().list();
                            val dailyCount = (Integer) values.get(0);
                            val totalCount = (Integer) values.get(1);
                            boolean capReached = false;
                            for(val capping : cappings){
                                //Break this loop
//                                val dailyCap = capping.getDailyCap();
//                                val totalCap = capping.getTotalCap();
//
//                                if((totalCount > totalCap)
//                                        || (dailyCount > dailyCap)
//                                        )
//                                {
//                                    capReached = true;
//                                    break;
//                                }

                            }
                            future.complete(false);
                        }
                        else{
                            log.error("",ar.cause());
                            future.complete(false);
                        }
                    });
        }
        return future;
    }
}
