package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.BannerAdTypeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 19/07/17.
 */
@Getter
@JsonDeserialize(using = BannerAdTypeDeserializer.class)
public enum BannerAdType {

    UNKNOWN(0),
    XHTML_TEXT(1),
    XHTML_BANNER(2),
    JAVASCRIPT(3),
    IFRAME(4);

    private final int code;

    BannerAdType(final int code){
        this.code = code;
    }

    public static BannerAdType from(final int code){
        BannerAdType result = null;
        switch(code){
            case 1 : result = XHTML_TEXT; break;
            case 2 : result = XHTML_BANNER; break;
            case 3 : result = JAVASCRIPT; break;
            case 4 : result = IFRAME; break;
            default : result = UNKNOWN ;break;
        }
        return result;
    }


}
