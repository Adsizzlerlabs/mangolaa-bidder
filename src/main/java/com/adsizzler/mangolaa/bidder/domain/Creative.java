package com.adsizzler.mangolaa.bidder.domain;

import lombok.Data;

/**
 * Created by ankushsharma on 13/09/17.
 */
@Data
public class Creative {

    private final Integer id;
    private final Integer name;
    private final Status status;
    private final Integer campaignId;

}
