package com.adsizzler.mangolaa.bidder.service;

import in.ankushs.dbip.api.GeoEntity;
import io.vertx.core.Future;

/**
 * Created by ankushsharma on 26/09/17.
 */
public interface GeoIpService {

    GeoEntity lookup(String ip);

    Future<GeoEntity> lookupAsync(String ip);

}
