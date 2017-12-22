package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;


import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.AdPositionDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 26/07/17.
 */
@Getter
@JsonDeserialize(using = AdPositionDeserializer.class)
public enum AdPosition {

    UNKNOWN(0),
    ABOVE_THE_FOLD(1),
    DEPRECATED(2),
    BELOW_THE_FOLD(3),
    HEADER(4),
    FOOTER(5),
    SIDEBAR(6),
    FULL_SCREEN(7);

    private final int code;

    AdPosition(final int code){
        this.code = code;
    }

    public static AdPosition from(final int code){
        AdPosition result ;
        switch(code){
            case 0 : result = UNKNOWN; break;
            case 1 : result = ABOVE_THE_FOLD; break;
            case 2 : result = DEPRECATED; break;
            case 3 : result = BELOW_THE_FOLD; break;
            case 4 : result = HEADER; break;
            case 5 : result = FOOTER; break;
            case 6 : result = SIDEBAR; break;
            default  : result = FULL_SCREEN; break;
        }
        return result;
    }

}
