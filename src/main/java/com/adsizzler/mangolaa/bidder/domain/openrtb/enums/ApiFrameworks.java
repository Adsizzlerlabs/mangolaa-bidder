package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.ApiFrameworkDeserializer;
import com.adsizzler.mangolaa.bidder.json.jackson.serializers.ApiFrameworksSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

/**
 * Created by Ankush on 26/07/17.
 */
@Getter
@JsonDeserialize(using = ApiFrameworkDeserializer.class)
@JsonSerialize(using = ApiFrameworksSerializer.class)
public enum ApiFrameworks {

    UNKNOWN(0),
    VPAID_1_0(1),
    VPAID_2_0(2),
    MRAID_1(3),
    ORMMA(4),
    MRAID_2(5),
    MRAID_3(6);

    private final int code;

    ApiFrameworks(final int code){
        this.code = code;
    }

    public static ApiFrameworks from(final int code){
        ApiFrameworks result;

        switch(code){
            case 1 : result = VPAID_1_0; break;
            case 2 : result = VPAID_2_0; break;
            case 3 : result = MRAID_1; break;
            case 4 : result = ORMMA; break;
            case 5 : result = MRAID_2; break;
            case 6 : result = MRAID_3; break;
            default : result = UNKNOWN; break;
        }

        return result;
    }



}
