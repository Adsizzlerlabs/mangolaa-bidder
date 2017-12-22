package com.adsizzler.mangolaa.bidder.handler;

import com.adsizzler.mangolaa.bidder.service.JsonService;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ankushsharma on 12/09/17.
 */
@Component
public class HomePageHandler implements Handler<RoutingContext> {

    @Autowired
    JsonService jsonService;

    @Override
    public void handle(final RoutingContext rc) {
       rc.response().end("Success");
    }

}
