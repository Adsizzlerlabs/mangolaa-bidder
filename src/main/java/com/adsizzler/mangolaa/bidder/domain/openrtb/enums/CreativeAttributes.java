package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.CreativeAttributesDeserializer;
import com.adsizzler.mangolaa.bidder.json.jackson.serializers.CreativeAttributesSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

/**
 * Created by Ankush on 19/07/17.
 */
@Getter
@JsonDeserialize(using = CreativeAttributesDeserializer.class)
@JsonSerialize(using = CreativeAttributesSerializer.class)
public enum CreativeAttributes {

    UNKNOWN(0),
    AUDIO_AD_AUTO_PLAY(1),
    AUDIO_AD_USER_INITIATED(2),
    EXPANDABLE_AUTOMATIC(3),
    EXPANDABLE_USER_INITIATED_CLICK(4),
    EXPANDABLE_USER_INITIATED_ROLLOVER(5),
    IN_BANNER_VIDEO_AD_AUTO_PLAY(6),
    IN_BANNER_VIDEO_AD_USER_INITIATED(7),
    POP(8),
    PROVOCATIVE_OR_SUGGESTED_IMAGERY(9),
    ANIMATION(10),
    SURVEYS(11),
    TEXT_ONLY(12),
    USER_INTERACTIVE(13),
    WINDOWS_DIALOG_OR_ALERT_STYLE(14),
    HAS_AUDIO_ON_OR_OFF_BUTTON(15),
    AD_PROVIDES_SKIP_BUTTON(16),
    ADOBE_FLASH(17);

    private final int code;

    CreativeAttributes(final int code){
        this.code = code;
    }


    public static CreativeAttributes from(final int code){
        CreativeAttributes result;
        switch(code){
            case 1 : result = AUDIO_AD_AUTO_PLAY; break;
            case 2 : result = AUDIO_AD_USER_INITIATED; break;
            case 3 : result = EXPANDABLE_AUTOMATIC; break;
            case 4 : result = EXPANDABLE_USER_INITIATED_CLICK; break;
            case 5 : result = EXPANDABLE_USER_INITIATED_ROLLOVER; break;
            case 6 : result = IN_BANNER_VIDEO_AD_AUTO_PLAY; break;
            case 7 : result = IN_BANNER_VIDEO_AD_USER_INITIATED; break;
            case 8 : result = POP; break;
            case 9 : result = PROVOCATIVE_OR_SUGGESTED_IMAGERY; break;
            case 10 : result = ANIMATION; break;
            case 11 : result = SURVEYS; break;
            case 12 : result = TEXT_ONLY; break;
            case 13 : result = USER_INTERACTIVE; break;
            case 14 : result = WINDOWS_DIALOG_OR_ALERT_STYLE; break;
            case 15 : result = HAS_AUDIO_ON_OR_OFF_BUTTON; break;
            case 16 : result = AD_PROVIDES_SKIP_BUTTON; break;
            case 17 : result = ADOBE_FLASH; break;
            default : result =  UNKNOWN; break;
        }
        return result;
    }

}
