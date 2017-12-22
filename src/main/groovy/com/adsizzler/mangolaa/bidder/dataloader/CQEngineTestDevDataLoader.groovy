package com.adsizzler.mangolaa.bidder.dataloader

import com.adsizzler.mangolaa.bidder.domain.Advertiser
import com.adsizzler.mangolaa.bidder.domain.Campaign
import com.adsizzler.mangolaa.bidder.domain.Capping
import com.adsizzler.mangolaa.bidder.domain.Status
import com.adsizzler.mangolaa.bidder.repository.AdvertiserRepository
import com.adsizzler.mangolaa.bidder.repository.CampaignRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct
import java.time.LocalDate

/**
 * Created by ankushsharma on 04/10/17.
 */
@Component
@Profile(["dev","test"])
@Slf4j
class CQEngineTestDevDataLoader {

    @Autowired
    CampaignRepository campaignRepository

    @Autowired
    AdvertiserRepository advertiserRepository

    @PostConstruct
    void init(){

        def advertiser = Advertiser
                  .builder()
                  .name("Some name")
                  .id( 1)
                  .domain("adv.com")
                  .build()

        advertiserRepository.save(advertiser)

        log.debug 'Saving Campaigns to CQEngine for testing purposes'
        def campaign = Campaign
                .builder()
                .status(Status.ACTIVE)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(11))
                .name("Hello")
                .id(12)
                .advId(1)
                .capping(Capping.builder().dailyCap(111).totalCap(2222).build())
                .packageName('some.package.name')
                .build()

        campaignRepository.save(campaign)
    }
}
