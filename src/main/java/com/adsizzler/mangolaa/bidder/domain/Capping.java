package com.adsizzler.mangolaa.bidder.domain;

import com.adsizzler.mangolaa.bidder.dataloader.domain.CampaignFreqCap;
import lombok.Builder;
import lombok.Getter;

/**
 * Created by ankushsharma on 03/10/17.
 */
@Builder
@Getter
public class Capping {

    private final CampaignFreqCap.TimeUnit timeUnit;
    private final Integer count;

}
