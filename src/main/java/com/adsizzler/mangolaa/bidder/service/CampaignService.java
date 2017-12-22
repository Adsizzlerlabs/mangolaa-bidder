package com.adsizzler.mangolaa.bidder.service;

import com.adsizzler.mangolaa.bidder.domain.Campaign;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.BidRequest;
import com.adsizzler.mangolaa.bidder.service.impl.UserAgentAnalysisServiceImpl.UserAgentDetails;
import in.ankushs.dbip.api.GeoEntity;
import io.vertx.core.Future;

import java.util.Set;

/**
 * Created by ankushsharma on 01/09/17.
 */
public interface CampaignService {

    Future<Set<Campaign>> findAll(
            BidRequest bidRequest,
            GeoEntity geoEntity,
            UserAgentDetails userAgentDetails
    );


}
