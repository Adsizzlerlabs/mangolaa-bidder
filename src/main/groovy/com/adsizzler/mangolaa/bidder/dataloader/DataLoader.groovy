package com.adsizzler.mangolaa.bidder.dataloader

import com.adsizzler.mangolaa.bidder.dataloader.domain.CampaignEntity
import com.adsizzler.mangolaa.bidder.dataloader.repository.AdvertiserEntityRepository
import com.adsizzler.mangolaa.bidder.domain.Campaign
import com.googlecode.cqengine.IndexedCollection
import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

/**
 * Load Data from DB and cache them in CQEngine
 * Created by ankushsharma on 27/09/17.
 */
@Component
@Slf4j
class DataLoader {

    final AdvertiserEntityRepository advertisersRepo
    final IndexedCollection<Campaign> campaignRepo

    DataLoader(
            AdvertiserEntityRepository advertisersRepo,
            IndexedCollection<Campaign> campaignRepo
    )
    {
        this.advertisersRepo = advertisersRepo
    }

    //Load data every 5 seconds
    @Scheduled(fixedRate = 5000L)
    void fetchCmsData(){

        log.info 'Fetching Adv, Campaigns, Creatives and other related data from DB'
        def advertisers = advertisersRepo.findAll()

        // Transform Set<CampaignEntity> -> Set<Campaign>
        Set<CampaignEntity> campaignEntities = advertisers.campaigns

        Set<Campaign> campaigns = campaignEntities.collect{
                                            def campaignId = it.id
                                            def startDate = it.startDate
                                            def endDate = it.endDate
                                            def status = it.status
                                            def campaignPhase = it.campaignPhase
                                            Float bid = it.bid
                                            Float totalBudget = it.totalBudget
                                            Float dailyBudget = it.dailyBudget
                                            def pricingModel = it.pricingModel
                                            def customData = it.customData
                                            def categoryEntites = it.categories
                                            def geoTargettingEntities = it.geoTargettingEntities
                                            def carrierTargettingEntities = it.carrierTargettingEntities
                                            def blacklistedIpEntities = it.blacklistedIps
                                            def blacklistedAppIdEntities = it.blacklistedAppIds
                                            def whitelistedAppIds = it.whitelistedAppIds
                                            def blacklistedUserAgentEntities = it.blacklistedUserAgents
                                            def freqCapEntities = it.freqCaps
                                            return Campaign
                                                        .builder()
                                                            .id(campaignId)
                                                            .startDate(startDate)
                                                            .endDate(endDate)
                                                            .status(status)
                                                            .campaignPhase(campaignPhase)
                                                            .bid(bid)
                                                            .totalBudget(totalBudget)
                                                            .dailyBudget(dailyBudget)
                                                            .pricingModel(pricingModel)
                                                            .customData(customData)
//                                                            .cappings(freqCapEntities.collect{ new Capp})
                                                            .blacklistedUserAgents(blacklistedUserAgentEntities.collect{ it.userAgent } )
                                                            .whitelistedAppIds(whitelistedAppIds.collect{ it.appId } )
                                                            .blacklistedIps(blacklistedIpEntities.collect{ it.ip} + blacklistedIpEntities.collect{ it.ipSeries} )
                                                            .blacklistedAppIds(blacklistedAppIdEntities.collect{ it.appId} )
                                                            .carriers(carrierTargettingEntities.collect{ it.carrier} )
                                                            .location(geoTargettingEntities.collect{ it.location } )
                                                            .categorySet(categoryEntites.collect{ it.category })
                                                        .build()
                                   }


    }

}
