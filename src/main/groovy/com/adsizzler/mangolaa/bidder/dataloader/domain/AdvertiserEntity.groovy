package com.adsizzler.mangolaa.bidder.dataloader.domain

import javax.persistence.*

/**
 * Created by ankushsharma on 27/09/17.
 */
@Entity
@Table(name='advertisers')
class AdvertiserEntity extends BaseEntity{

    @Column(name = 'name', nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    String name

    @Column(name = 'domain_name', nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    String domain

    @OneToMany(mappedBy = "advertiser", cascade = CascadeType.ALL)
    Set<CampaignEntity> campaigns

}
