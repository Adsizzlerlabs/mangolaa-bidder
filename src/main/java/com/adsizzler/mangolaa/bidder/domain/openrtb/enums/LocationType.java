package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;


import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.LocationTypeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 26/07/17.
 */
@Getter
@JsonDeserialize(using = LocationTypeDeserializer.class)
public enum LocationType {

    UNKNOWN(0),
    GPS_LOCATION_SERVICES(1),
    IP_ADDRESS(2),
    USER_PROVIDED(3);

    private final int code;

    LocationType(final int code) {
        this.code = code;
    }

    public static LocationType from(final int code){
        LocationType result;

        switch(code){
            case 1 : result = GPS_LOCATION_SERVICES; break;
            case 2 : result = IP_ADDRESS; break;
            case 3 : result = USER_PROVIDED; break;
            default : result = UNKNOWN;
        }
        return result;
    }



}
