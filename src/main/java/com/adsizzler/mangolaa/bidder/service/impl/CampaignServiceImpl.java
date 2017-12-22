package com.adsizzler.mangolaa.bidder.service.impl;

import com.adsizzler.mangolaa.bidder.domain.Campaign;
import com.adsizzler.mangolaa.bidder.domain.FrequencyCap;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;
import com.adsizzler.mangolaa.bidder.repository.CampaignRepository;
import com.adsizzler.mangolaa.bidder.service.AdvertiserService;
import com.adsizzler.mangolaa.bidder.service.CampaignService;
import com.adsizzler.mangolaa.bidder.service.FrequencyCapService;
import com.adsizzler.mangolaa.bidder.service.impl.UserAgentAnalysisServiceImpl.UserAgentDetails;
import com.adsizzler.mangolaa.bidder.util.PreConditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import in.ankushs.dbip.api.GeoEntity;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.adsizzler.mangolaa.bidder.util.CollectionUtil.isNullOrEmpty;
import static java.util.stream.Collectors.toSet;

/**
 * Created by ankushsharma on 04/09/17.
 */
@Service
@Slf4j
public class CampaignServiceImpl implements CampaignService {

    private static final Set<Campaign> NO_CAMPAIGNS = Collections.emptySet();

    private final CampaignRepository campaignRepository;
    private final FrequencyCapService frequencyCapService;
    private final AdvertiserService advertiserService;

    public CampaignServiceImpl(
            final CampaignRepository campaignRepository,
            final FrequencyCapService frequencyCapService,
            final AdvertiserService advertiserService
     )
    {
        this.campaignRepository = campaignRepository;
        this.frequencyCapService = frequencyCapService;
        this.advertiserService = advertiserService;
    }

    @Override
    public Future<Set<Campaign>> findAll(
            final BidRequest bidReq,
            final GeoEntity geoEntity,
            final UserAgentDetails userAgentDetails
    )
    {
        PreConditions.notNull(bidReq,"bidReq cannot be null");
        PreConditions.notNull(geoEntity,"geoEntity cannot be null");
        PreConditions.notNull(userAgentDetails,"userAgentDetails cannot be null");

        val future = Future.<Set<Campaign>>future();
        val user = bidReq.getUser();
        //Find all advertisers that are elligible to bid.
        val advertisers = advertiserService.findAll(bidReq);

        campaignRepository
                .findAll(bidReq,advertisers)
                .setHandler( ar -> {
                    if(ar.succeeded()){
                        val campaigns = ar.result();
                        if(Objects.isNull(campaigns)){
                            log.debug("No Campaigns found in Repository");
                            future.complete(NO_CAMPAIGNS);
                        }
                        else {
                            val freqCapFutures = Lists.<Future>newArrayListWithCapacity(campaigns.size());
                            for(val campaign : campaigns){
                                //Using Future compose to combine two Future functions
                                val capReachedFuture = frequencyCapService.capReached(user, campaign);
                                Future freqCapDetailsFuture = capReachedFuture
                                                                .compose( capReached -> {
                                                                    final Future<FrequencyCap> fut = Future.future();
                                                                    fut.complete( new FrequencyCap(campaign, capReached));
                                                                    return fut;
                                                               });
                                freqCapFutures.add(freqCapDetailsFuture);
                            }
                            if(isNullOrEmpty(freqCapFutures)) {
                                future.complete(NO_CAMPAIGNS);
                            }
                            else{
                                CompositeFuture.all(ImmutableList.copyOf(freqCapFutures))
                                                .setHandler( ar1 -> {
                                                    if(ar1.succeeded()){
                                                        val freqCapDetails = getFreqCapDetails(ar1.result().list());
                                                        //No Need for nullOrEmptyCheck, its already been applied to 'futures'
                                                        val campaignsWithCapNotReached = Sets.<Campaign>newHashSetWithExpectedSize(campaigns.size());
                                                        for(val fq : freqCapDetails){
                                                            val campaign = fq.getCampaign();
                                                            val capReached = fq.getCapReached();
                                                            if(!capReached){
                                                                campaignsWithCapNotReached.add(campaign);
                                                            }
                                                        }
                                                        future.complete(campaignsWithCapNotReached);
                                                    }
                                                    else{
                                                        future.complete(NO_CAMPAIGNS);
                                                    }
                                                });
                            }
                        }
                    }
                    else{
                        future.fail(ar.cause());
                    }
        });

        return future;
    }

    private static Set<FrequencyCap> getFreqCapDetails(final List<Object> objects){
        if(isNullOrEmpty(objects)){
            return Collections.emptySet();
        }
        return objects.stream()
                      .map( FrequencyCap.class :: cast )
                      .collect(toSet());
    }

}
