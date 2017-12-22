package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

/**
 * Created by Ankush on 01/08/17.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ImpressionEntity {
    EXCHANGE(0),
    UPSTREAM(1);

    private final int code;

    ImpressionEntity(final int code){
        this.code = code;
    }

    public static ImpressionEntity from(final int code){
        ImpressionEntity result;

        switch(code){
            case 0 : result = EXCHANGE; break;
            case 1 : result = UPSTREAM; break;
            default : result = EXCHANGE; break;
        }
        return result;
    }
}
