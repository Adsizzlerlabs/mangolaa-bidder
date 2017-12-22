package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.adsizzler.mangolaa.bidder.json.jackson.deserializers.AuctionTypeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

/**
 * Created by Ankush on 19/07/17.
 */
@Getter
@JsonDeserialize(using = AuctionTypeDeserializer.class)
public enum AuctionType {

    FIRST_PRICE(1),
    SECOND_PRICE(2);

    private final int code;

    AuctionType(final int code){
        this.code = code;
    }

    public static AuctionType from(final int code){
        AuctionType auctionType ;
        switch(code){
            case 1 : auctionType = FIRST_PRICE ; break;
            case 2 : auctionType = SECOND_PRICE ; break;
            default : auctionType = SECOND_PRICE ; break;
        }
        return auctionType;
    }

}
