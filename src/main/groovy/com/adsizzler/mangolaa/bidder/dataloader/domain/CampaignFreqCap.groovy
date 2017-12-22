package com.adsizzler.mangolaa.bidder.dataloader.domain

import groovy.transform.ToString

import javax.persistence.*

/**
 * Created by ankushsharma on 29/11/17.
 */
@Entity
@Table(name='campaigns')
@ToString(includePackage = false)
class CampaignFreqCap extends BaseEntity{

    @Column(name = "count", nullable = false, columnDefinition = "INT DEFAULT 2")
    Integer count

    @Column(name = "time_unit", columnDefinition = "INT DEFAULT 2")
    TimeUnit timeUnit

    @ManyToOne
    @JoinColumn(name = "camp_id")
    CampaignEntity campaign


    static enum TimeUnit{
        HOUR(1),
        DAY(2),
        WEEK(3),
        MONTH(4)

        final int code

        TimeUnit(int code){
            this.code = code
        }

        static TimeUnit from(int code){
            def result
            switch(code){
                case 1 : result = HOUR; break
                case 2 : result = DAY; break
                case 3 : result = WEEK; break
                case 4 : result = MONTH; break
                default : result = HOUR
            }
            result
        }
     }
}
