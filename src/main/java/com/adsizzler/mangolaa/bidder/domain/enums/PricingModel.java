package com.adsizzler.mangolaa.bidder.domain.enums;

import lombok.Getter;

/**
 * Created by ankushsharma on 27/09/17.
 */
@Getter
public enum PricingModel {

    UNKNOWN(0),
    CPM(1),
    CPC(2),
    CPI(3);

    private final int code;

    PricingModel(final int code){
        this.code = code;
    }

    public static PricingModel from(final int code){
        PricingModel result;
        switch(code){
            case 1 : result = CPM;
            case 2 : result = CPC;
            case 3 : result = CPI;
            default : result = UNKNOWN;
        }
        return result;
    }
}
