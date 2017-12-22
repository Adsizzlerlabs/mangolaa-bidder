package com.adsizzler.mangolaa.bidder.service;


import com.adsizzler.mangolaa.bidder.service.impl.UserAgentAnalysisServiceImpl.UserAgentDetails;
import io.vertx.core.Future;

/**
 * Created by ankushsharma on 09/10/17.
 */
public interface UserAgentAnalysisService {

    Future<UserAgentDetails> getDetailsAsync(String userAgent);

    UserAgentDetails getDetails(String userAgent) throws Exception;

}
