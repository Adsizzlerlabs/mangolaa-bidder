package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.IpServicesVendor;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.LocationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Ankush on 19/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Geo {

    @JsonProperty(value = "lat")
    private final Float latitude;

    @JsonProperty(value = "lon")
    private final Float longitude;

    @JsonProperty(value = "type")
    private final LocationType locationType;

    @JsonProperty(value = "accuracy")
    private final Integer accuracy;

    @JsonProperty(value = "lastfix")
    private final Integer lastFix;

    @JsonProperty(value = "ipservice")
    private final IpServicesVendor ipServicesVendor;

    @JsonProperty(value = "country")
    private final String country;

    @JsonProperty(value = "region")
    private final String region;

    @JsonProperty(value = "metro")
    private final String metroCode;

    @JsonProperty(value = "city")
    private final String city;

    @JsonProperty(value = "zip")
    private final String zipCode;

    @JsonProperty(value = "utcoffset")
    private final Integer utcOffset;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;

}
