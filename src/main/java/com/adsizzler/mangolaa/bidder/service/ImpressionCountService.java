package com.adsizzler.mangolaa.bidder.service;

import com.adsizzler.mangolaa.bidder.domain.openrtb.request.User;
import io.vertx.core.Future;

/**
 * Created by ankushsharma on 03/10/17.
 */
public interface ImpressionCountService {
    //Get the daily count of impression served for a particular user and campaign id
    Future<Integer> getDailyCount(User user, Integer campaignId);

    //Get the total count of impression served for a particular user and campaign id
    Future<Integer> getTotalCount(User user, Integer campaignId);

}
