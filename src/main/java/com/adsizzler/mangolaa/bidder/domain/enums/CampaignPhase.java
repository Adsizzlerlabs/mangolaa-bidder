package com.adsizzler.mangolaa.bidder.domain.enums;

import lombok.Getter;

/**
 * Created by ankushsharma on 30/11/17.
 */
@Getter
public enum CampaignPhase {

    UNKNOWN(0),
    TEST(1),
    PRODUCTION(2);

    private final int code;

    CampaignPhase(final int code){
        this.code = code;
    }

    public static CampaignPhase from(final int code){
        CampaignPhase result;
        switch(code){
            case 1 : result = TEST; break;
            case 2 : result = PRODUCTION; break;
            default : result = UNKNOWN;
        }
        return result;
    }
}
