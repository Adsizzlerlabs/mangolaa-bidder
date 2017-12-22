package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.DeviceTypeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 26/07/17.
 */
@Getter
@JsonDeserialize(using = DeviceTypeDeserializer.class)
public enum DeviceType {

    UNKNOWN(0),
    MOBILE_TABLET(1),
    PERSONAL_COMPUTER(2),
    TV(3),
    PHONE(4),
    TABLET(5),
    CONNECTED_DEVICE(6),
    SET_TOP_BOX(7);

    private final int code;

    DeviceType(final int code){
        this.code = code;
    }

    public static DeviceType from(final int code){
        DeviceType result;

        switch(code){
            case 1 : result = MOBILE_TABLET; break;
            case 2 : result = PERSONAL_COMPUTER; break;
            case 3 : result = TV; break;
            case 4 : result = PHONE; break;
            case 5 : result = TABLET; break;
            case 6 : result = CONNECTED_DEVICE; break;
            case 7 : result = SET_TOP_BOX; break;
            default : result = UNKNOWN; break;
        }

        return result;
    }
}
