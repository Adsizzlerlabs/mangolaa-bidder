package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.GenderDeserializer;
import com.adsizzler.mangolaa.bidder.util.Strings;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 27/07/17.
 */
@Getter
@JsonDeserialize(using =  GenderDeserializer.class)
public enum Gender {

    UNKNOWN,
    MALE,
    FEMALE;

    public static Gender from(final String description){
        Gender result;
        if(Strings.hasText(description)){
            switch(description){
                case "m" :
                case "M" : result = MALE; break;
                case "f" :
                case "F" : result = FEMALE; break;
                default  : result = UNKNOWN; break;
            }
        }
        else{
            result = Gender.UNKNOWN;
        }
        return result;
    }

    @JsonIgnore
    public boolean isMale(){
        return this == MALE;
    }

    @JsonIgnore
    public boolean isFemale(){
        return this == FEMALE;
    }

    @JsonIgnore
    public boolean isOther(){
        return this == UNKNOWN;
    }
}
