package com.adsizzler.mangolaa.bidder.dataloader.domain

import javax.persistence.*

/**
 * Created by ankushsharma on 27/09/17.
 */
@Entity
@Table(name='whitelisted_app_ids')
class WhitelistedAppIds extends BaseEntity {

    @Column(name= 'app_id', nullable = false, columnDefinition = "VARCHAR(200) DEFAULT ''")
    String appId

    @ManyToOne
    @JoinColumn(name = "camp_id")
    CampaignEntity campaign

}
