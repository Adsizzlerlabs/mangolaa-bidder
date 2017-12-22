package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.MediaRatingDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 26/07/17.
 */
@Getter
@JsonDeserialize(using = MediaRatingDeserializer.class)
public enum SourceRelationship{
    UNKNOWN(0),
    DIRECT(1),
    INDIRECT(2);

    private final int code;

    SourceRelationship(final int code){
        this.code = code;
    }

    public static SourceRelationship from(final int code){
        SourceRelationship result;

        switch(code){
            case 1 : result = DIRECT; break;
            case 2 : result = INDIRECT; break;
            default : result = UNKNOWN; break;
        }
        return result;
    }



}
