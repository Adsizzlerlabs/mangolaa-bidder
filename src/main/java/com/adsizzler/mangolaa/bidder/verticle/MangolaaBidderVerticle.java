package com.adsizzler.mangolaa.bidder.verticle;

import com.adsizzler.mangolaa.bidder.handler.*;
import com.adsizzler.mangolaa.bidder.handler.failure.BidRequestHandlerFailureHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * Created by ankushsharma on 12/09/17.
 */
@Component
@Scope(SCOPE_PROTOTYPE)
public class MangolaaBidderVerticle extends AbstractVerticle {

    private final Router router;
    private final BidRequestHandler bidReqHandler;
    private final GeoIPHandler geoIPHandler;
    private final BidRequestHandlerFailureHandler bidReqHandlerFailureHandler;
    private final HomePageHandler homePageHandler;
    private final MetricsHandler metricsHandler;
    private final CampaignViewHandler campaignViewHandler;
    private final UserAgentDetailsAnalysisHandler userAgentDetailsAnalysisHandler;

    public MangolaaBidderVerticle(
            final BidRequestHandler bidReqHandler,
            final BidRequestHandlerFailureHandler bidReqHandlerFailureHandler,
            final Router router,
            final HomePageHandler homePageHandler,
            final GeoIPHandler geoIPHandler,
            final MetricsHandler metricsHandler,
            final CampaignViewHandler campaignViewHandler,
            final UserAgentDetailsAnalysisHandler userAgentDetailsAnalysisHandler
    )
    {
        this.bidReqHandler = bidReqHandler;
        this.bidReqHandlerFailureHandler = bidReqHandlerFailureHandler;
        this.router = router;
        this.homePageHandler = homePageHandler;
        this.geoIPHandler = geoIPHandler;
        this.metricsHandler = metricsHandler;
        this.campaignViewHandler = campaignViewHandler;
        this.userAgentDetailsAnalysisHandler = userAgentDetailsAnalysisHandler;
    }

    @Override
    public void start(){

        router.route().handler(BodyHandler.create());

        router.get("/home")
              .handler(homePageHandler);

        router.get("/metrics")
              .handler(metricsHandler);

        router.post("/")
              .handler(bidReqHandler)
              .failureHandler(bidReqHandlerFailureHandler);

        router.get("/geoip")
              .handler(geoIPHandler);

        router.get("/campaigns")
              .handler(campaignViewHandler);

        router.get("/ua")
                .handler(userAgentDetailsAnalysisHandler);
    }
}
