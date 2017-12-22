package com.adsizzler.mangolaa.bidder.repository.impl;

import com.adsizzler.mangolaa.bidder.domain.Advertiser;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;
import com.adsizzler.mangolaa.bidder.repository.AdvertiserRepository;
import com.adsizzler.mangolaa.bidder.util.PreConditions;
import com.googlecode.cqengine.IndexedCollection;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

import static com.googlecode.cqengine.query.QueryFactory.in;
import static com.googlecode.cqengine.query.QueryFactory.not;


/**
 * Created by ankushsharma on 11/10/17.
 */
@Repository
@Slf4j
public class CQEngineAdvertiserRepositoryImpl implements AdvertiserRepository {

    private final IndexedCollection<Advertiser> advertiserRepo;

    public CQEngineAdvertiserRepositoryImpl(final IndexedCollection<Advertiser> advertiserRepo){
        this.advertiserRepo = advertiserRepo;
    }

    @Override
    public Set<Advertiser> findAll(final BidRequest bidRequest)
    {
        PreConditions.notNull(bidRequest,"bidRequest cannot be null");
        val blockedAdvDomains = bidRequest.getBlockedAdvDomains();

        //SELECT * FROM advertisers WHERE domain NOT IN (blockedAdvDomainsSet)
        val query = not(in(Advertiser.DOMAIN,blockedAdvDomains));

        val resultSet = advertiserRepo.retrieve(query);
        val size =  resultSet.size();
        val advertisers = new HashSet<Advertiser>(size);

        for(val advertiser :resultSet){
            advertisers.add(advertiser);
        }
        return advertisers;
    }

    @Override
    public void save(final Advertiser adv) {
        PreConditions.notNull(adv,"adv cannot be null");
        advertiserRepo.add(adv);
    }
}
