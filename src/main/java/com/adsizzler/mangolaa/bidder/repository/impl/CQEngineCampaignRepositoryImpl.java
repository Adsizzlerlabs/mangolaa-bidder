package com.adsizzler.mangolaa.bidder.repository.impl;

import com.adsizzler.mangolaa.bidder.domain.Advertiser;
import com.adsizzler.mangolaa.bidder.domain.Campaign;
import com.adsizzler.mangolaa.bidder.domain.Status;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;
import com.adsizzler.mangolaa.bidder.repository.CampaignRepository;
import com.adsizzler.mangolaa.bidder.service.impl.UserAgentAnalysisServiceImpl;
import com.adsizzler.mangolaa.bidder.util.Dates;
import com.adsizzler.mangolaa.bidder.util.PreConditions;
import com.googlecode.cqengine.IndexedCollection;
import io.vertx.core.Future;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.adsizzler.mangolaa.bidder.domain.Campaign.*;
import static com.googlecode.cqengine.query.QueryFactory.*;
import static java.util.stream.Collectors.toSet;

/**
 * Created by ankushsharma on 01/09/17.
 */
@Repository
@Slf4j
public class CQEngineCampaignRepositoryImpl implements CampaignRepository{

    private static final ExecutorService executor;

    static{
        val threads = 1;
        log.info("Initializing {} thread pool with {} threads", UserAgentAnalysisServiceImpl.class.getName(), threads);
        executor = Executors.newFixedThreadPool(threads);
    }

    private final IndexedCollection<Campaign> campaignRepo;

    public CQEngineCampaignRepositoryImpl(final IndexedCollection<Campaign> campaignRepo){
        this.campaignRepo = campaignRepo;
    }


    @Override
    public Future<Set<Campaign>> findAll(
            final BidRequest bidRequest,
            final Set<Advertiser> advertisers
    )
    {
        PreConditions.notNull(bidRequest,"bidRequest cannot be null");
        PreConditions.notNull(advertisers, "advertisers cannot be null");
        val future = Future.<Set<Campaign>>future();

        val today = Dates.utcNow().toLocalDate();
        val blacklistedPackages = bidRequest.getBlockedApps();

        executor.execute( () -> {
            val advIds = advertisers.stream()
                                    .map(Advertiser::getId)
                                    .collect(toSet());

            //SELECT * FROM campaigns c
            //WHERE c.advId IN (advIds)
            //AND c.status == ACTIVE
            //AND (today BETWEEN :startDate AND :endDate))
            val query = and(
                            in(ADV_ID,advIds),
                            equal(STATUS, Status.ACTIVE),
                            greaterThanOrEqualTo(START_DATE,today),
                            lessThanOrEqualTo(END_DATE,today),
                            not(
                                    in(PACKAGE_NAME,blacklistedPackages)
                            )
             );

            final Set<Campaign> campaigns = new HashSet<>();
            for(val campaign : campaignRepo.retrieve(query)){
                campaigns.add(campaign);
            }
//            future.complete(campaigns);
            future.complete(new HashSet<>(campaignRepo));
        });
        return future;
    }

    @Override
    public Future<Void> save(final Campaign campaign) {
        PreConditions.notNull(campaign,"campaign cannot be null");
        campaignRepo.add(campaign);
        return Future.<Void>succeededFuture();
    }

    @Override
    public Future<Set<Campaign>> findAll() {
        val future = Future.<Set<Campaign>>future();
        future.complete(new HashSet<>(campaignRepo));
        return future;
    }
}
