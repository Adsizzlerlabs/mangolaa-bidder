package com.adsizzler.mangolaa.bidder.domain;

import lombok.Data;

/**
 * Created by ankushsharma on 06/10/17.
 */

@Data
public class FrequencyCap{

    private final Campaign campaign;
    private final Boolean capReached;

    public FrequencyCap(
            final Campaign campaign,
            final Boolean capReached
    )
    {
        this.campaign = campaign;
        this.capReached = capReached;
    }

}
