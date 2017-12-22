package com.adsizzler.mangolaa.bidder.domain;

import com.adsizzler.mangolaa.bidder.util.Strings;
import lombok.Getter;
import lombok.experimental.var;

/**
 * Created by Ankush on 17/07/17.
 */
@Getter
public enum Status {

    UNKNOWN(0),
    ACTIVE(1),
    DEACTIVE(2),
    PAUSED(3);

    private final int code;

    Status(final int code){
        this.code = code;
    }

    public static Status from(final int code){
        Status result;
        switch(code){
            case 1 : result = ACTIVE; break;
            case 2 : result = DEACTIVE; break;
            case 3 : result = PAUSED; break;
            default : result = UNKNOWN; break;
        }
        return result;
    }

    public static Status from(final String string){
        var status  = UNKNOWN;
        if(Strings.hasText(string)){
            if(string.equalsIgnoreCase("deactive")){
                status =  DEACTIVE;
            }
            else if (string.equalsIgnoreCase("active")){
                status =  ACTIVE;
            }
        }
        return status;
    }
}
