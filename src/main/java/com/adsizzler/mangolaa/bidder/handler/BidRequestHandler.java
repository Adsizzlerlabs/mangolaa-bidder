package com.adsizzler.mangolaa.bidder.handler;

import com.adsizzler.mangolaa.bidder.domain.Campaign;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.ApiFrameworks;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Currency;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.Device;
import com.adsizzler.mangolaa.bidder.domain.openrtb.response.Bid;
import com.adsizzler.mangolaa.bidder.domain.openrtb.response.BidResponse;
import com.adsizzler.mangolaa.bidder.domain.openrtb.response.SeatBid;
import com.adsizzler.mangolaa.bidder.service.*;
import com.adsizzler.mangolaa.bidder.service.impl.UserAgentAnalysisServiceImpl.UserAgentDetails;
import com.adsizzler.mangolaa.bidder.util.ResponseUtil;
import com.google.common.collect.Sets;
import in.ankushs.dbip.api.GeoEntity;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Created by ankushsharma on 08/09/17.
 */
@Component
@Slf4j
public class BidRequestHandler implements Handler<RoutingContext> {

    private final JsonService jsonService;
    private final CampaignService campaignService;
    private final GeoIpService geoIpService;
    private final UserAgentAnalysisService uaService;
    private final BidRequestService bidRequestService;
    private final BidResponseService bidResponseService;

    public BidRequestHandler(
            final JsonService jsonService,
            final CampaignService campaignService,
            final GeoIpService geoIpService,
            final UserAgentAnalysisService uaService,
            final BidRequestService bidRequestService,
            final BidResponseService bidResponseService
    )
    {
        this.campaignService = campaignService;
        this.jsonService = jsonService;
        this.geoIpService = geoIpService;
        this.uaService = uaService;
        this.bidRequestService = bidRequestService;
        this.bidResponseService = bidResponseService;
    }

    @Override
    public void handle(final RoutingContext rc) {
        val jsonReq = rc.getBodyAsString();
        log.debug("JSON :{}", jsonReq);

        val bidReqFuture = jsonService.toObject(jsonReq, BidRequest.class);

        bidReqFuture.setHandler( ar -> {
            if(ar.succeeded()){
                val bidReq = ar.result();
                val ip = bidReq.getIp();
                val userAgent = getUserAgent(bidReq.getDevice());

                val geoEntityFuture = geoIpService.lookupAsync(ip);
                val userAgentDetailsFuture = uaService.getDetailsAsync(userAgent);

                CompositeFuture.all(geoEntityFuture,userAgentDetailsFuture)
                               .setHandler( ar1 -> {
                                   if(ar1.succeeded()){
                                       val results = ar1.result().list();
                                       val geoEntity = getGeo(results);
                                       val userAgentDetails = getUaDetails(results);

                                       log.debug("{}", bidReq);
                                       log.debug("{}", geoEntity);

                                       val campaignsFuture = campaignService.findAll(bidReq, geoEntity, userAgentDetails);

                                       campaignsFuture.setHandler( ar2 -> {
                                           if(ar2.succeeded()){
                                               val campaigns = ar2.result();
                                               val bidResp = buildBidResponse(campaigns, bidReq);
                                               val jsonBidRespFuture = jsonService.toJson(bidResp);

                                               jsonBidRespFuture.setHandler( ar3 -> {
                                                   val httpResp = rc.response();
                                                   if(ar3.succeeded()){
                                                       val resp = ar3.result();
                                                       ResponseUtil.buildResponse(resp,httpResp);
                                                       bidResponseService.queueToKafka(bidResp);
                                                   }
                                                   else{
                                                       rc.fail(ar3.cause());
                                                   }
                                               });
                                           }
                                           else{
                                               rc.fail(ar2.cause());
                                           }
                                       });
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

    private BidResponse buildBidResponse(
            final Set<Campaign> campaigns,
            final BidRequest bidRequest)
    {
        val seats = Sets.<SeatBid>newHashSet();
        val bids = Sets.<Bid>newHashSet();

        bids.add(
                Bid.builder()
                        .adId(UUID.randomUUID().toString())
                        .adMarkup("html")
                        .apiFramework(ApiFrameworks.MRAID_1)
                        .bundle("bundle")
                        .winUrl("http://www.google.com")
                        .widthRatio(1)
                        .dealId(UUID.randomUUID().toString())
                        .height(1)
                        .billingUrl("http://www.google.com")
                        .build()
        );
        seats.add(
          SeatBid.builder()
                  .bids(bids)
                  .buyerSeatId(UUID.randomUUID().toString())
                  .group(1)

                  .build()
        );
        return BidResponse.builder()
                .bidRequestId(UUID.randomUUID().toString())
                .bidResponseId(UUID.randomUUID().toString())
                .currency(Currency.AFN.toString())
                .seatBids(
                        seats
                )
                .build();
    }

    private static String getUserAgent(final Device device){
        String result = "";
        if(Objects.nonNull(device)){
            result = device.getUserAgent();
        }
        return result;
     }

    private static GeoEntity getGeo(final List<Object> objects){
        return (GeoEntity) objects.get(0);
     }

    private static UserAgentDetails getUaDetails(final List<Object> objects){
        return (UserAgentDetails) objects.get(1);
    }


}
