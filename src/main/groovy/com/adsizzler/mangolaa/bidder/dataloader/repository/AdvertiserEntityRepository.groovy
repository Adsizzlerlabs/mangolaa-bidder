package com.adsizzler.mangolaa.bidder.dataloader.repository

import com.adsizzler.mangolaa.bidder.dataloader.domain.AdvertiserEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by ankushsharma on 27/09/17.
 */
interface AdvertiserEntityRepository extends JpaRepository<AdvertiserEntity,Integer> {

}