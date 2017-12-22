package com.adsizzler.mangolaa.bidder.service;

import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;

/**
 * Created by ankushsharma on 17/10/17.
 */
public interface BidRequestService {

    void queueToKafka(BidRequest bidRequest);

}
