package com.adsizzler.mangolaa.bidder.dataloader.domain

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import java.time.LocalDateTime

/**
 * Created by ankushsharma on 27/09/17.
 */
@MappedSuperclass
class BaseEntity {

    @Id
    @GeneratedValue
    Integer id

    @Column(name = 'created', nullable = false)
    LocalDateTime created

    @Column(name = 'updated', nullable = false)
    LocalDateTime updated

}
