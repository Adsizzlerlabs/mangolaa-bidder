package com.adsizzler.mangolaa.bidder.dataloader.domain

import javax.persistence.*

/**
 * Created by ankushsharma on 27/09/17.
 */
@Entity
@Table(name = 'geo_targetting')
class GeoTargettingEntity extends BaseEntity {

    @Column(name = 'location', nullable = false, columnDefinition = "VARCHAR(200) DEFAULT ''")
    String location

    @ManyToOne
    @JoinColumn(name = "camp_id")
    CampaignEntity campaign

}
