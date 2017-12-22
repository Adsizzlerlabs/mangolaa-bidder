package com.adsizzler.mangolaa.bidder.domain.openrtb.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * Created by Ankush on 03/08/17.
 */
@Data
@Builder
public class SeatBid {

    @JsonProperty(value = "bid", required = true)
    private final Set<Bid> bids;

    @JsonProperty("seat")
    private final String buyerSeatId;

    @JsonProperty(value = "group", defaultValue = "0")
    private final Integer group;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;
}
