package com.adsizzler.mangolaa.bidder.handler;

import com.adsizzler.mangolaa.bidder.repository.CampaignRepository;
import com.adsizzler.mangolaa.bidder.service.JsonService;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import lombok.val;
import org.springframework.stereotype.Component;

import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;

/**
 * Created by ankushsharma on 04/10/17.
 */
@Component
public class CampaignViewHandler implements Handler<RoutingContext> {

    private final CampaignRepository campaignRepository;
    private final JsonService jsonService;

    public CampaignViewHandler(
            final CampaignRepository campaignRepository,
            final JsonService jsonService
     )
    {
        this.campaignRepository = campaignRepository;
        this.jsonService = jsonService;
    }

    @Override
    public void handle(final RoutingContext rc) {
        val resp = rc.response();
        val campaignsFuture = campaignRepository.findAll();
        campaignsFuture.setHandler( ar -> {
            if(ar.succeeded()){
                val campaigns = ar.result();
                //Map needed so that we can render valid JSON, and not just an array
                jsonService.toPrettyJson(unmodifiableMap(singletonMap("campaigns",campaigns)))
                            .setHandler( ar1 -> {
                                if(ar.succeeded()){
                                    resp.putHeader("Content-Type","application/json")
                                        .end(ar1.result());
                                }
                                else{
                                    rc.fail(ar1.cause());
                                }
                            });

            }
            else{
                rc.fail(ar.cause());
            }
        });
    }
}
