package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.ModeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 18/07/17.
 */
@Getter
@JsonDeserialize(using = ModeDeserializer.class)
public enum Mode {
    LIVE(0),
    TEST(1);

    private final int code;

    Mode(final int code){
        this.code = code;
    }

    public static Mode from(final int code){
        Mode mode ;
        switch(code){
            case 0 : mode = LIVE; break;
            case 1 : mode = TEST; break;
            default : mode = LIVE; break;
        }
        return mode;
    }

    @JsonIgnore
    public boolean isTestMode(){
        return this == TEST;
    }

    @JsonIgnore
    public boolean isLiveMode(){
        return this == LIVE;
    }
}
