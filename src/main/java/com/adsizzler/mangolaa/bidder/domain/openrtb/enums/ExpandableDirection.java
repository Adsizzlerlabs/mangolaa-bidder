package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.ExpandableDirectionDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 26/07/17.
 */
@Getter
@JsonDeserialize(using = ExpandableDirectionDeserializer.class)
public enum ExpandableDirection {

    UNKNOWN(0),
    LEFT(1),
    RIGHT(2),
    UP(3),
    DOWN(4),
    FULL_SCREEN(5);

    private final int code;

    ExpandableDirection(final int code){
        this.code = code;
    }

    public static ExpandableDirection from(final int code){
        ExpandableDirection result ;
        switch(code){
            case 1 : result = LEFT; break;
            case 2 : result = RIGHT; break;
            case 3 : result = UP; break;
            case 4 : result = DOWN; break;
            case 5 : result = FULL_SCREEN; break;
            default : result = UNKNOWN; break;
        }
        return result;
    }

}
