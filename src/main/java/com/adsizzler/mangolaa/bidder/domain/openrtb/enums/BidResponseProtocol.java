package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.BidResponseProtocolDeserializer;
import com.adsizzler.mangolaa.bidder.json.jackson.serializers.BidResponseProtocolSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

/**
 * Created by Ankush on 04/08/17.
 */
@Getter
@JsonDeserialize(using = BidResponseProtocolDeserializer.class)
@JsonSerialize(using = BidResponseProtocolSerializer.class)
public enum BidResponseProtocol {

    UNKNOWN(0),
    VAST_1_0(1),
    VAST_2_0(2),
    VAST_3_0(3),
    VAST_1_0_WRAPPER(4),
    VAST_2_0_WRAPPER(5),
    VAST_3_0_WRAPPER(6),
    VAST_4_0(7),
    VAST_4_0_WRAPPER(8),
    DAST_1_0(9),
    DAST_1_0_WRAPPER(10);


    private final int code;

    BidResponseProtocol(final int code){
        this.code = code;
    }

    public static BidResponseProtocol from(final int code){
        BidResponseProtocol result;

        switch(code){
            case 1 : result = VAST_1_0; break;
            case 2 : result = VAST_2_0; break;
            case 3 : result = VAST_3_0; break;
            case 4 : result = VAST_1_0_WRAPPER; break;
            case 5 : result = VAST_2_0_WRAPPER; break;
            case 6 : result = VAST_3_0_WRAPPER; break;
            case 7 : result = VAST_4_0; break;
            case 8 : result = VAST_4_0_WRAPPER; break;
            case 9 : result = DAST_1_0; break;
            case 10 : result = DAST_1_0_WRAPPER; break;
            default : result = UNKNOWN; break;
        }
        return result;
    }
}
