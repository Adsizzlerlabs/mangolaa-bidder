package com.adsizzler.mangolaa.bidder.handler.failure;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import lombok.val;
import org.springframework.stereotype.Component;

/**
 * Created by ankushsharma on 12/09/17.
 */
@Component
public class BidRequestHandlerFailureHandler implements Handler<RoutingContext> {

    @Override
    public void handle(final RoutingContext rc) {
        val ex = rc.failure();
        val resp = rc.response();
        resp.end(ex.toString());
    }
}
