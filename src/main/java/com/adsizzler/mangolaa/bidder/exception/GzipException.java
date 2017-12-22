package com.adsizzler.mangolaa.bidder.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ankush on 20/07/17.
 */
@Setter
@Getter
public class GzipException extends RuntimeException {

    private final String message;

    public GzipException(final String message){
        this.message = message;
    }
}
