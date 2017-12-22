package com.adsizzler.mangolaa.bidder.service.impl;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Category;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Currency;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.Device;
import com.adsizzler.mangolaa.bidder.protobuff.OpenRtb;
import com.adsizzler.mangolaa.bidder.service.BidRequestService;
import com.adsizzler.mangolaa.bidder.util.PreConditions;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.kafka.client.producer.impl.KafkaProducerRecordImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.adsizzler.mangolaa.bidder.constants.KafkaTopics.BID_REQUEST_TOPIC;
import static java.util.stream.Collectors.toSet;

/**
 * Created by ankushsharma on 17/10/17.
 */
@Service
@Slf4j
public class BidRequestServiceImpl implements BidRequestService {

    private static final ExecutorService executor;

    static{
        val threads = 1;
        log.info("Initializing {} thread pool with pool size {}", BidRequestServiceImpl.class.getName(),threads);
        executor = Executors.newFixedThreadPool(threads);
    }

    @PreDestroy
    void cleanup(){
        log.info("Closing BidRequestServiceImpl ExecutorService");
        executor.shutdown();
        log.info("BidRequestServiceImpl ExecutorService closed ? {} ", executor.isShutdown());
    }

    private final KafkaProducer<String,byte[]> kafka;

    public BidRequestServiceImpl(final KafkaProducer<String,byte[]> kafka)
    {
        this.kafka = kafka;
    }

    @Override
    public void queueToKafka(
            final BidRequest bidRequest
    )
    {
        PreConditions.notNull(bidRequest, "bidRequest cannot be null");
        executor.execute( () -> {
            val write = buildProtobuffBidRequest(bidRequest).toByteArray();
            val record = new KafkaProducerRecordImpl<String,byte[]>(BID_REQUEST_TOPIC,write);
            kafka.write(record, done -> {
                if(!done.succeeded()){
                    log.error("",done.cause());
                }
            }).exceptionHandler( ex -> {
                log.error("",ex);
            });
        });
    }


    private static OpenRtb.BidRequest buildProtobuffBidRequest(final BidRequest bidReq)
    {
        PreConditions.notNull(bidReq, "bidReq cannot be null");

        val id = bidReq.getId();

        val allImps = bidReq.forAllImps();
        val auctionType = bidReq.getAuctionType();
        val blackListedAdvertisers = bidReq.getBlacklistedAdvertisers();
        val blockedAdvDomains =  bidReq.getBlockedAdvDomains();
        val blockedApps = bidReq.getBlockedApps();
        val blockedCategories = bidReq.getBlockedCategories();
        val currencies = bidReq.getCurrencies();
        val device = bidReq.getDevice();
        val impressionReq = bidReq.getImpressionRequests();

        val maxTimeToRespond = bidReq.getMaxTimeToRespond();
        val mode = bidReq.getMode();
        val regulations = bidReq.getRegulations();
        val source =  bidReq.getSource();
        val user = bidReq.getUser();
        val whitelistedAdvertisers = bidReq.getWhitelistedAdvertisers();
        val whitelistedLanguages = bidReq.getWhitelistedLanguages();

        return OpenRtb.BidRequest
                .newBuilder()
                    .setId(id)
                    .setAllimps(allImps)
                    .setAt(OpenRtb.AuctionType.forNumber(auctionType.getCode()))
                    .addAllBseat(blackListedAdvertisers)
                    .addAllBadv(blockedAdvDomains)
                    .addAllBapp(blockedApps)
                    .addAllCur(currencies.stream().map(Currency :: toString).collect(toSet()))
                    .addAllBcat(blockedCategories.stream().map(Category :: getCode).collect(toSet()))

                .build();
    }

    private static OpenRtb.BidRequest.Device buildProtobuffDevice(final Device device){
        PreConditions.notNull(device,"device cannot be null");
        val carrier = device.getCarrier();
        val connType = device.getConnectionType();
        val dontTrack = device.isDontIgnore();
        val flashVer =  device.getFlashVersion();
        val geo = device.getGeo();
        val hardwareDeviceIdm5 = device.getHardwareDeviceIdMd5();
        val hardwareDeviceIdsSha1 = device.getHardwareDeviceIdSha1();
        val ipv4 = device.getIpv4();
        val ipv6 = device.getIpv6();
        val javascriptSupported = device.getJavascriptSupported();
        val macAddrMd5 = device.getMacAddressMd5();
        val macAddressSha1 = device.getMacAddressSha1();
        val make = device.getMake();
        val model = device.getModel();
        val os = device.getOs();
        val osVer = device.getOsVersion();
        val deviceType = device.getDeviceType();
        val pixelHeight = device.getPixelsHeight();
        val pixelWidth = device.getPixelWidth();
        val screenInchesSize = device.getScreenSizeInches();
        val trackingRestricted = device.getTrackingRestricted();
        val userAgent = device.getUserAgent();

        return OpenRtb.BidRequest.Device
                .newBuilder()
                    .setCarrier(carrier)
                    .setConnectiontype(OpenRtb.ConnectionType.forNumber(connType.getCode()))
                    .setDnt(dontTrack)
                    .setFlashver(flashVer)

                .build();
    }

}
