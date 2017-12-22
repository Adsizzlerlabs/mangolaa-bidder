package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.IpServicesVendorDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 27/07/17.
 */
@Getter
@JsonDeserialize(using = IpServicesVendorDeserializer.class)
public enum IpServicesVendor {

    UNKNOWN(0),
    QUOVA(1),
    MAXMIND(2),
    DIGITAL_ELEMENT(3);

    private final int code;

    IpServicesVendor(final int code){
        this.code = code;
    }

    public static IpServicesVendor from(final int code){
        IpServicesVendor result;
        switch(code){
            case 1 : result = QUOVA; break;
            case 2 : result = MAXMIND; break;
            case 3 : result = DIGITAL_ELEMENT; break;
            default : result = UNKNOWN; break;
        }

        return result;
    }

}
