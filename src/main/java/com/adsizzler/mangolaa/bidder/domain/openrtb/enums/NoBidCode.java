package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.serializers.NoBidCodeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

/**
 * Created by Ankush on 03/08/17.
 */
@Getter
@JsonSerialize(using = NoBidCodeSerializer.class)
public enum NoBidCode {

    UNKNOWN_ERROR(0),
    TECHNICAL_ERROR(1),
    INVALID_REQUEST(2),
    KNOWN_WEB_SPIDER(3),
    SUSPECTED_NON_HUMAN_TRAFFIC(4),
    CLOUD_DATA_CENTER_OR_PROXY_IP(5),
    UNSUPPORTED_DEVICE(6),
    BLOCKED_PUBLISHER_OR_SITE(7),
    UNMATCHED_USER(8),
    DAILY_READER_CAP_MET(9),
    DAILY_DOMAIN_CAP_MET(10);

    private final int code;

    NoBidCode(final int code) {
        this.code = code;
    }

    public static NoBidCode from(final int code){
        NoBidCode result;
        switch(code){
            case 0 : result = UNKNOWN_ERROR; break;
            case 1 : result = TECHNICAL_ERROR; break;
            case 2 : result = INVALID_REQUEST; break;
            case 3 : result = KNOWN_WEB_SPIDER; break;
            case 4 : result = SUSPECTED_NON_HUMAN_TRAFFIC; break;
            case 5 : result = CLOUD_DATA_CENTER_OR_PROXY_IP; break;
            case 6 : result = UNSUPPORTED_DEVICE; break;
            case 7 : result = BLOCKED_PUBLISHER_OR_SITE; break;
            case 8 : result = UNMATCHED_USER; break;
            case 9 : result = DAILY_READER_CAP_MET; break;
            case 10 : result = DAILY_DOMAIN_CAP_MET; break;
            default : result = UNKNOWN_ERROR; break;
        }
        return result;
    }


}
