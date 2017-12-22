package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.ContextDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 26/07/17.
 */
@Getter
@JsonDeserialize(using = ContextDeserializer.class)
public enum Context {
    UNKNOWN(0),
    VIDEO(1),
    GAME(2),
    MUSIC(3),
    APPLICATION(4),
    TEXT(5),
    OTHER(6);

    private final int code;

    Context(final int code){
        this.code = code;
    }

    public static Context from(final int code){
        Context result;

        switch(code){
            case 1 : result = VIDEO; break;
            case 2 : result = GAME; break;
            case 3 : result = MUSIC; break;
            case 4 : result = APPLICATION; break;
            case 5 : result = TEXT; break;
            case 6 : result = OTHER; break;
            default : result = UNKNOWN; break;
        }

        return result;
    }
}
