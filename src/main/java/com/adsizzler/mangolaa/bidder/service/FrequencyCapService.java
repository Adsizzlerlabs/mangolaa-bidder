package com.adsizzler.mangolaa.bidder.service;

import com.adsizzler.mangolaa.bidder.domain.Campaign;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.User;
import io.vertx.core.Future;

/**
 * Created by ankushsharma on 03/10/17.
 */
public interface FrequencyCapService {

    Future<Boolean> capReached(
            User user,
            Campaign campaign
    );

}
