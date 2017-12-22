package com.adsizzler.mangolaa.bidder.handler;

import com.adsizzler.mangolaa.bidder.service.JsonService;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.dropwizard.MetricsService;
import io.vertx.ext.web.RoutingContext;
import lombok.val;
import org.springframework.stereotype.Component;

/**
 * Created by Ankush on 04/05/17.
 */
@Component
public class MetricsHandler implements Handler<RoutingContext> {

    private final MetricsService metricsService;
    private final Vertx vertx;
    private final JsonService jsonService;

    MetricsHandler(
            final Vertx vertx,
            final  MetricsService metricsService,
            final JsonService jsonService)
    {
        this.metricsService = metricsService;
        this.vertx = vertx;
        this.jsonService = jsonService;
    }

    @Override
    public void handle(final RoutingContext routingContext) {
        val response = routingContext.response();
        val jsonMetrics = metricsService.getMetricsSnapshot(vertx);

        jsonService.toPrettyJson(jsonMetrics)
                   .setHandler( ar -> {
                       val json = ar.result();
                       response.putHeader("Content-type","application/json")
                        .putHeader("Connection","Keep-Alive")
                        .end(json);
                   }) ;
    }
}
