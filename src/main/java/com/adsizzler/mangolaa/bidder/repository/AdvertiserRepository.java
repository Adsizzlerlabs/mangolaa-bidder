package com.adsizzler.mangolaa.bidder.repository;

import com.adsizzler.mangolaa.bidder.domain.Advertiser;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;

import java.util.Set;

/**
 * Created by ankushsharma on 11/10/17.
 */
public interface AdvertiserRepository {

    Set<Advertiser> findAll(BidRequest bidRequest);

    void save(Advertiser adv);
}
