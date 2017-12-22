package com.adsizzler.mangolaa.bidder.dataloader.domain

import groovy.transform.ToString

import javax.persistence.*

/**
 * Created by ankushsharma on 30/11/17.
 */
@Entity
@Table(name='blacklisted_ips')
@ToString(includePackage = false)
class BlacklistedIpEntity extends BaseEntity {

    @Column(name = "ip", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    String ip

    @Column(name = "ip_series", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    String ipSeries

    @ManyToOne
    @JoinColumn(name = "camp_id")
    CampaignEntity campaign

}
