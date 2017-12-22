package com.adsizzler.mangolaa.bidder.dataloader.domain

import com.adsizzler.mangolaa.bidder.domain.Capping
import com.adsizzler.mangolaa.bidder.domain.Status
import com.adsizzler.mangolaa.bidder.domain.enums.CampaignPhase
import com.adsizzler.mangolaa.bidder.domain.enums.PricingModel
import groovy.transform.ToString

import javax.persistence.*
import java.time.LocalDate

/**
 * Created by ankushsharma on 27/09/17.
 */
@Entity
@Table(name='campaigns')
@ToString(includePackage = false)
class CampaignEntity extends BaseEntity{

    @Column(name = 'name', nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    String name

    @Column(name = 'start_date', nullable = false)
    LocalDate startDate

    @Column(name = 'end_date', nullable = false)
    LocalDate endDate

    @Column(name = 'status', nullable = false, columnDefinition = "INT DEFAULT 2")
    Status status

    @Column(name = 'app_package_name', nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    String appName

    //Bid details
    @Column(name = 'bid', nullable = false, columnDefinition = "INT DEFAULT 0")
    Float bid

    @Column(name = 'total_budget',nullable = false, columnDefinition = "INT DEFAULT 0")
    Float totalBudget

    @Column(name = 'daily_budget', nullable = false, columnDefinition = "INT DEFAULT 0")
    Float dailyBudget

    @Column(name = 'pricing_model', nullable = false, columnDefinition = "INT DEFAULT 0")
    PricingModel pricingModel

    @Column(name = 'campaign_phase', nullable = true, columnDefinition = 'INT DEFAULT 1')
    CampaignPhase campaignPhase

    @Column(name = 'custom_data', columnDefinition = "VARCHAR(255) DEFAULT ''")
    String customData

    // ~~~~~ Relationships ~~~~~~
    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    Set<GeoTargettingEntity> geoTargettingEntities

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    Set<CarrierTargettingEntity> carrierTargettingEntities

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    Set<BlacklistedAppIds> blacklistedAppIds

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    Set<WhitelistedAppIds> whitelistedAppIds

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    Set<CampaignFreqCap> freqCaps

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    Set<BlacklistedIpEntity> blacklistedIps

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    Set<BlacklistedUserAgentEntity> blacklistedUserAgents

    @OneToMany(mappedBy = "cateogry", cascade = CascadeType.ALL)
    Set<CategoryEntity> categories

    @ManyToOne
    @JoinColumn(name = "adv_id")
    AdvertiserEntity advertiser

    //Using getters so that we don't have to deal with Nullpointers or use use Elvis operator somewhere else in code
    Set<GeoTargettingEntity> getGeoTargettingEntities(){
        if(Objects.isNull(geoTargettingEntities)){
            return []
        }
        return geoTargettingEntities
    }

    Set<CarrierTargettingEntity> getCarrierTargettingEntities(){
        if(Objects.isNull(carrierTargettingEntities)){
            return []
        }
        return carrierTargettingEntities
    }

    Set<BlacklistedAppIds> getBlacklistedAppIds(){
        if(Objects.isNull(blacklistedAppIds)){
            return []
        }
        return blacklistedAppIds
    }

    Set<WhitelistedAppIds> getWhitelistedAppIds(){
        if(Objects.isNull(whitelistedAppIds)){
            return []
        }
        return whitelistedAppIds
    }

    Set<Capping> getFreqCaps(){
        if(Objects.isNull(freqCaps)){
            return []
        }
        return freqCaps
    }

    Set<BlacklistedIpEntity> getBlacklistedIps(){
        if(Objects.isNull(blacklistedIps)){
            return []
        }
        return blacklistedIps
    }

    Set<BlacklistedUserAgentEntity> getBlacklistedUserAgents(){
        if(Objects.isNull(blacklistedUserAgents)){
            return []
        }
        return blacklistedUserAgents
    }

    Set<CategoryEntity> getCategories(){
        if(Objects.isNull(categories)){
            return []
        }
        return categories
    }
}
