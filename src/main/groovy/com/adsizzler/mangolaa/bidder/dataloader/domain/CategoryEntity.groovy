package com.adsizzler.mangolaa.bidder.dataloader.domain

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Category

import javax.persistence.*

/**
 * Created by ankushsharma on 01/12/17.
 */
@Entity
@Table(name='carrier_targetting')
class CategoryEntity extends BaseEntity{

    @Column(name = "category", nullable = false, length = 50)
    Category category

    @ManyToOne
    @JoinColumn(name = "camp_id")
    CampaignEntity campaign

}
