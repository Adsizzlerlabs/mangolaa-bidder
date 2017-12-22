package com.adsizzler.mangolaa.bidder.service;

import com.adsizzler.mangolaa.bidder.domain.Advertiser;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;

import java.util.Set;

/**
 * Created by ankushsharma on 11/10/17.
 */
public interface AdvertiserService {

    Set<Advertiser> findAll(BidRequest bidRequest);

}
