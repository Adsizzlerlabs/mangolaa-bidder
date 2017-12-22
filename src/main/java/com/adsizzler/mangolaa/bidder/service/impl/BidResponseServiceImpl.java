package com.adsizzler.mangolaa.bidder.service.impl;

import com.adsizzler.mangolaa.bidder.domain.Campaign;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.ApiFrameworks;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Currency;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;
import com.adsizzler.mangolaa.bidder.domain.openrtb.response.Bid;
import com.adsizzler.mangolaa.bidder.domain.openrtb.response.BidResponse;
import com.adsizzler.mangolaa.bidder.domain.openrtb.response.SeatBid;
import com.adsizzler.mangolaa.bidder.protobuff.OpenRtb;
import com.adsizzler.mangolaa.bidder.service.BidResponseService;
import com.adsizzler.mangolaa.bidder.util.Dates;
import com.adsizzler.mangolaa.bidder.util.PreConditions;
import com.google.common.collect.Sets;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.kafka.client.producer.impl.KafkaProducerRecordImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.adsizzler.mangolaa.bidder.constants.KafkaTopics.BID_RESPONSE_TOPIC;

/**
 * Created by ankushsharma on 17/10/17.
 */
@Service
@Slf4j
public class BidResponseServiceImpl implements BidResponseService{

    private static final ExecutorService executor;

    static{
        val threads = 1;
        log.info("Initializing {} thread pool with pool size {}", BidResponseServiceImpl.class.getName(),threads);
        executor = Executors.newFixedThreadPool(threads);
    }

    @PreDestroy
    void cleanup(){
        log.info("Closing BidResponseServiceImpl ExecutorService");
        executor.shutdown();
        log.info("BidResponseServiceImpl ExecutorService closed ? {} ", executor.isShutdown());
    }

    private final KafkaProducer<String,byte[]> kafka;

    public BidResponseServiceImpl(final KafkaProducer<String,byte[]> kafka)
    {
        this.kafka = kafka;
    }


    @Override
    public void queueToKafka(final BidResponse bidResponse) {
        PreConditions.notNull(bidResponse, "bidResponse cannot be null");
        executor.execute( () -> {
            val write = buildProtoBuffBidResponse(bidResponse).toByteArray();
            val record = new KafkaProducerRecordImpl<String,byte[]>(BID_RESPONSE_TOPIC,write);
            kafka.write(record, done -> {
                if(!done.succeeded()){
                    log.error("{}",done.cause());
                }
            }).exceptionHandler( ex -> {
                log.error("{}",ex);
            });
        });
    }

    private static OpenRtb.BidResponse buildProtoBuffBidResponse(final BidResponse bidResponse)
    {
        val nowInMs = Dates.utcNowAsMs();
        val bidReqId = bidResponse.getBidRequestId();
        val bidRespId = bidResponse.getBidResponseId();
        val currency = bidResponse.getCurrency();

        val bid = OpenRtb.BidResponse
                .SeatBid.Bid.newBuilder()
                .addCat("jndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvjjndvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjjndvjdnvjdnvj")
                .addCat("asnansjasnas")
                .addAdomain("some domain")
                .setId(UUID.randomUUID().toString())
                .setAdid(UUID.randomUUID().toString())
                .setApi(OpenRtb.APIFramework.MRAID_1)
                .setImpid(UUID.randomUUID().toString())
                .setPrice(11.0)
                .build();


        return OpenRtb.BidResponse
                .newBuilder()
                .setId(UUID.randomUUID().toString())

                .setCur(currency)
                .setBidid(bidReqId)
                .setId(bidRespId)
                .setMs(nowInMs)
                .setNbr(OpenRtb.NoBidReason.BLOCKED_PUBLISHER)
                .addSeatbid(
                        OpenRtb.BidResponse.SeatBid.newBuilder()
                                .addBid(bid)
                                .build()
                )
                .build();
    }
    private static BidResponse buildBidResponse(
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

//
//    public static void main(String[] args) throws Exception {
//        val json = Json.toPrettyJson(buildBidResponse(null,null)).getBytes();
//        val pb = buildProtoBuffBidResponse(buildBidResponse(null,null)).toByteArray();
//        System.out.println("Json Size " + json.length);
//        System.out.println("PB Size " + pb.length);
//
//    }
}
