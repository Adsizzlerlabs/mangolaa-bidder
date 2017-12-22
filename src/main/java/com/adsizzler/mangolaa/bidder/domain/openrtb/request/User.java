package com.adsizzler.mangolaa.bidder.domain.openrtb.request;


import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.Map;
import java.util.Set;

/**
 * Created by Ankush on 27/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@ToString
public class User {

    @JsonProperty(value = "id")
    private final String id;

    @JsonProperty(value = "buyeruid")
    private final String buyerUid;

    @JsonProperty(value = "yob")
    private final Integer yearOfBirth;

    @JsonProperty(value = "gender")
    private final Gender gender;

    @JsonProperty(value = "keywords")
    private final String keywords;

    @JsonProperty(value = "customdata")
    private final String customData;

    @JsonProperty(value = "geo")
    private final Geo geo;

    @JsonProperty(value = "data")
    private final Set<Data> data;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;
}
