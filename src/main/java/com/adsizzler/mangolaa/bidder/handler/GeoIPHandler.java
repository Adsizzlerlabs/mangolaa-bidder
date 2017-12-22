package com.adsizzler.mangolaa.bidder.handler;

import com.adsizzler.mangolaa.bidder.service.GeoIpService;
import com.adsizzler.mangolaa.bidder.service.JsonService;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;

/**
 * Created by ankushsharma on 26/09/17.
 */
@Component
public class GeoIPHandler implements Handler<RoutingContext> {

    private final GeoIpService geoIPService;
    private final JsonService jsonService;

    public GeoIPHandler(
            final GeoIpService geoIPService,
            final JsonService jsonService
    )
    {
        this.geoIPService = geoIPService;
        this.jsonService = jsonService;
    }

    @Override
    public void handle(final RoutingContext rc) {
        val start = System.nanoTime();
        val req = rc.request();
        val resp = rc.response();
        val ip = req.getParam("ip");
        val geoEntity = geoIPService.lookup(ip);
        val stop = System.nanoTime();

        final Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("geo", geoEntity);
        resultMap.put("timeTakenNano", stop-start);

        jsonService.toPrettyJson(unmodifiableMap(resultMap))
                   .setHandler( ar -> {
                       resp.putHeader("Content-Type","application/json")
                            .end(ar.result());
                   });
    }
}
