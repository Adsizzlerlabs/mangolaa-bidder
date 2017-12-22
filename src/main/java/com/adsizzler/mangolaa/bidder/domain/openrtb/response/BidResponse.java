package com.adsizzler.mangolaa.bidder.domain.openrtb.response;

import com.adsizzler.mangolaa.bidder.constants.CurrencyConstants;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.NoBidCode;
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
public class BidResponse {

    @JsonProperty("bidid")
    private final String bidResponseId;

    @JsonProperty("id")
    private final String bidRequestId;

    @JsonProperty("seatbid")
    private final Set<SeatBid> seatBids;

    @JsonProperty(value = "cur", defaultValue = CurrencyConstants.DEFAULT)
    private final String currency;

    @JsonProperty("customdata")
    private final String customData;

    @JsonProperty("nbr")
    private final NoBidCode noBidCode;

    @JsonProperty("ext")
    private final Map<String,Object> extensions;



}
