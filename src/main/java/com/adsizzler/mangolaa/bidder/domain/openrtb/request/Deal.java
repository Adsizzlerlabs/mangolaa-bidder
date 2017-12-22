package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.AuctionType;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Set;

/**
 * Created by Ankush on 03/08/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Deal {

    @JsonProperty(value = "id", required = true)
    private final String id;

    @JsonProperty(value = "bidfloor")
    private final Float bidFloor;

    @JsonProperty(value = "bidfloorcur")
    private final Currency bidFloorCurrency;

    @JsonProperty(value = "at")
    private final AuctionType auctionType;

    @JsonProperty(value = "wseat")
    private final Set<String> whitelistedAdvertisers;

    @JsonProperty(value = "wadomain")
    private final Set<String> whitelistedAdvDomains;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;

}
