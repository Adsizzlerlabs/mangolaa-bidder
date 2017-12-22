package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Ankush on 18/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class ImpressionRequest {

    @JsonProperty(value = "id", required=true)
    private final String id;

    @JsonProperty("metric")
    private final Metric metric;

    @JsonProperty("banner")
    private final Banner banner;

    @JsonProperty("displaymanager")
    private final String displayManager;

    @JsonProperty("displaymanagerver")
    private final String displayManagerVer;

    @JsonProperty("interstitial")
    private final Integer interstitial;

    @JsonProperty("tagId")
    private final String tagId;

    @JsonProperty("bidfloor")
    private final Float bidFloor;

    @JsonProperty("bidfloorcur")
    private final Currency bidFloorCurrency;

    @JsonProperty("secure")
    private final Integer secure;

    @JsonProperty("iframebuster")
    private final Set<String> iframeBusters;

    @JsonProperty("ext")
    private final Map<String,Object> extensions;

    @JsonIgnore
    public boolean inInterstitial(){
        return Objects.equals(interstitial,1);
    }

    @JsonIgnore
    public boolean isSecure(){
        return Objects.equals(secure, 1);
    }

}
