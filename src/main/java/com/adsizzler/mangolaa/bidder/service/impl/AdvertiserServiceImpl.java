package com.adsizzler.mangolaa.bidder.service.impl;

import com.adsizzler.mangolaa.bidder.domain.Advertiser;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;
import com.adsizzler.mangolaa.bidder.repository.AdvertiserRepository;
import com.adsizzler.mangolaa.bidder.service.AdvertiserService;
import com.adsizzler.mangolaa.bidder.util.PreConditions;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ankushsharma on 11/10/17.
 */
@Service
public class AdvertiserServiceImpl implements AdvertiserService {

    private final AdvertiserRepository advertiserRepository;

    public AdvertiserServiceImpl(final AdvertiserRepository advertiserRepository){
        this.advertiserRepository = advertiserRepository;
    }

    @Override
    public Set<Advertiser> findAll(final BidRequest bidRequest) {
        PreConditions.notNull(bidRequest,"bidRequest cannot be null");
        return advertiserRepository.findAll(bidRequest);
    }
}
