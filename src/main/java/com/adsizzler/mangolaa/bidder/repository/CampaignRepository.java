package com.adsizzler.mangolaa.bidder.repository;

import com.adsizzler.mangolaa.bidder.domain.Advertiser;
import com.adsizzler.mangolaa.bidder.domain.Campaign;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;
import io.vertx.core.Future;

import java.util.Set;

/**
 * Created by ankushsharma on 01/09/17.
 */
public interface CampaignRepository {

    Future<Set<Campaign>> findAll(BidRequest bidRequest, Set<Advertiser> advertisers);

    //For testing purposes only
    Future<Void> save(Campaign campaign);

    Future<Set<Campaign>> findAll();

}
