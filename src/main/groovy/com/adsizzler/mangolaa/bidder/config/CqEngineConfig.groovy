package com.adsizzler.mangolaa.bidder.config

import com.adsizzler.mangolaa.bidder.domain.Advertiser
import com.adsizzler.mangolaa.bidder.domain.Campaign
import com.googlecode.cqengine.ConcurrentIndexedCollection
import com.googlecode.cqengine.IndexedCollection
import com.googlecode.cqengine.index.hash.HashIndex
import com.googlecode.cqengine.index.navigable.NavigableIndex
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import static com.adsizzler.mangolaa.bidder.domain.Advertiser.DOMAIN
import static com.adsizzler.mangolaa.bidder.domain.Campaign.*

/**
 * Created by ankushsharma on 05/09/17.
 */
@Configuration
class CqEngineConfig {

    @Bean
    IndexedCollection<Campaign> campaignRepo(){
        def indexedCollection = new ConcurrentIndexedCollection<Campaign>()
        indexedCollection.addIndex(NavigableIndex.onAttribute(START_DATE))
        indexedCollection.addIndex(NavigableIndex.onAttribute(END_DATE))
        indexedCollection.addIndex(HashIndex.onAttribute(STATUS))
        indexedCollection.addIndex(HashIndex.onAttribute(ADV_ID))
        indexedCollection.addIndex(HashIndex.onAttribute(PACKAGE_NAME))
        indexedCollection.addIndex(HashIndex.onAttribute(CAMPAIGN_PHASE))
        indexedCollection.addIndex(HashIndex.onAttribute(TARGETTED_CARRIERS))
        indexedCollection.addIndex(HashIndex.onAttribute(TARGETTED_LOCATIONS))
        indexedCollection.addIndex(HashIndex.onAttribute(BLACKLISTED_IPS))
        indexedCollection.addIndex(HashIndex.onAttribute(BLACKLISTED_USER_AGENTS))
        indexedCollection.addIndex(HashIndex.onAttribute(WHITELISTED_APP_IDS))
        indexedCollection.addIndex(HashIndex.onAttribute(BLACKLISTED_APP_IDS))
        indexedCollection
    }

    @Bean
    IndexedCollection<Advertiser> advertiserRepo(){
        def indexedCollection = new ConcurrentIndexedCollection<Advertiser>()
        indexedCollection.addIndex(HashIndex.onAttribute(DOMAIN))
        indexedCollection
    }
}
