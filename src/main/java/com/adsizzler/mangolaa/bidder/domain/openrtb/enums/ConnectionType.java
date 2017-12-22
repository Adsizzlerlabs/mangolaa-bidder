package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.ConnectionTypeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 27/07/17.
 */
@Getter
@JsonDeserialize(using = ConnectionTypeDeserializer.class)
public enum ConnectionType {

    UNKNOWN(0),
    ETHERNET(1),
    WIFI(2),
    CELLULAR_NETWORK_UNKNOWN_GENERATION(3),
    CELLULAR_NETWORK_2G(4),
    CELLULAR_NETWORK_3G(5),
    CELLULAR_NETWORK_4G(6);

    private final int code;

    ConnectionType(final int code){
        this.code = code;
    }

    public static ConnectionType from(final int code){
        ConnectionType result;

        switch(code){
            case 1 : result = ETHERNET; break;
            case 2 : result = WIFI; break;
            case 3 : result = CELLULAR_NETWORK_UNKNOWN_GENERATION; break;
            case 4 : result = CELLULAR_NETWORK_2G; break;
            case 5 : result = CELLULAR_NETWORK_3G; break;
            case 6 : result = CELLULAR_NETWORK_4G; break;
            default : result = UNKNOWN; break;
        }

        return result;
    }
}

