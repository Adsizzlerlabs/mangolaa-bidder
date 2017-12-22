package com.adsizzler.mangolaa.bidder.dataloader.domain

import javax.persistence.*

/**
 * Created by ankushsharma on 27/09/17.
 */
@Entity
@Table(name='carrier_targetting')
class CarrierTargettingEntity extends BaseEntity{

    @Column(name = 'carrier', nullable = false, columnDefinition = "VARCHAR(200) DEFAULT ''")
    String carrier

    @ManyToOne
    @JoinColumn(name = "camp_id")
    CampaignEntity campaign


}
