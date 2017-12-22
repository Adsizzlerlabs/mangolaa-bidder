package com.adsizzler.mangolaa.bidder.dataloader.domain

import groovy.transform.ToString

import javax.persistence.*

/**
 * Created by ankushsharma on 01/12/17.
 */
@Entity
@Table(name='blacklisted_ips')
@ToString(includePackage = false)
class BlacklistedUserAgentEntity extends BaseEntity {

    @Column(name = "user_agent", nullable = false, columnDefinition = "VARCHAR DEFAULT''")
    String userAgent

    @ManyToOne
    @JoinColumn(name = "camp_id")
    CampaignEntity campaign

}
