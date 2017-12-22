package com.adsizzler.mangolaa.bidder.service;

import com.adsizzler.mangolaa.bidder.domain.openrtb.response.BidResponse;

/**
 * Created by ankushsharma on 17/10/17.
 */
public interface BidResponseService {

    void queueToKafka(BidResponse bidResponse);

}
