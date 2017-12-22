package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Ankush on 03/08/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Pmp {

    @JsonProperty(value = "deals")
    private final Set<Deal> deals;

    @JsonProperty(value = "deals")
    private final Map<String,Object> extensions;

    @JsonProperty(value = "private_auction", defaultValue = "0")
    private final Integer privateAuction;

    @JsonIgnore
    public boolean isPrivateAuction(){
        return Objects.equals(privateAuction,1);
    }


}
