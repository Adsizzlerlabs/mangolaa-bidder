package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.ProductionQualityDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 26/07/17.
 */
@Getter
@JsonDeserialize(using = ProductionQualityDeserializer.class)
public enum ProductionQuality {

    UNKNOWN(0),
    PROFESSIONALLY_PRODUCED(1),
    PROSUMER(2),
    USER_GENERATED_UGC(3);

    private final int code;

    ProductionQuality(final int code) {
        this.code = code;
    }

    public static ProductionQuality from(final int code){
        ProductionQuality result;

        switch(code){
            case 1 : result = PROFESSIONALLY_PRODUCED; break;
            case 2 : result = PROSUMER; break;
            case 3 : result = USER_GENERATED_UGC; break;
            default : result = UNKNOWN; break;
        }
        return result;
    }
}
