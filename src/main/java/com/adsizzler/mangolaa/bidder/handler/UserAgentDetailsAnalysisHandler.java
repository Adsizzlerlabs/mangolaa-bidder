package com.adsizzler.mangolaa.bidder.handler;

import com.adsizzler.mangolaa.bidder.service.JsonService;
import com.adsizzler.mangolaa.bidder.service.UserAgentAnalysisService;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;

/**
 * Created by ankushsharma on 09/10/17.
 */
@Component
public class UserAgentDetailsAnalysisHandler implements Handler<RoutingContext> {

    private final UserAgentAnalysisService userAgentAnalysisService;
    private final JsonService jsonService;

    public UserAgentDetailsAnalysisHandler(
            final UserAgentAnalysisService userAgentAnalysisService,
            final JsonService jsonService
    )
    {
        this.userAgentAnalysisService = userAgentAnalysisService;
        this.jsonService = jsonService;
    }

    @Override
    public void handle(final RoutingContext rc) {
        val start = System.nanoTime();

        val req = rc.request();
        val resp = rc.response();
        val userAgent = req.getParam("userAgent");
        val userAgentDetailsFuture = userAgentAnalysisService.getDetailsAsync(userAgent);

        userAgentDetailsFuture.setHandler( ar -> {
            val stop = System.nanoTime();
            val userAgentDetails = ar.result();

            final Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("uaDetails", userAgentDetails);
            resultMap.put("timeTakenNano", stop-start);

            jsonService.toPrettyJson(unmodifiableMap(resultMap))
                    .setHandler( ar1 -> {
                        resp.putHeader("Content-Type","application/json")
                                .end(ar1.result());
                    });
        });
    }
}
