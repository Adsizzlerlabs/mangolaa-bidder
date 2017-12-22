package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.MediaRatingDeserializer;
import com.adsizzler.mangolaa.bidder.json.jackson.serializers.MediaRatingSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

/**
 * Created by Ankush on 26/07/17.
 */
@Getter
@JsonDeserialize(using = MediaRatingDeserializer.class)
@JsonSerialize(using = MediaRatingSerializer.class)
public enum MediaRating {
    UNKNOWN(0),
    ALL_AUDIENCES(1),
    EVERYONE_OVER_12(2),
    MATURE_AUDIENCES(3);

    private final int code;

    MediaRating(final int code){
        this.code = code;
    }

    public static MediaRating from(final int code){
        MediaRating result ;

        switch(code){
            case 1 : result = ALL_AUDIENCES; break;
            case 2 : result = EVERYONE_OVER_12; break;
            case 3 : result = MATURE_AUDIENCES; break;
            default: result = UNKNOWN; break;
        }
        return result;
    }
}
