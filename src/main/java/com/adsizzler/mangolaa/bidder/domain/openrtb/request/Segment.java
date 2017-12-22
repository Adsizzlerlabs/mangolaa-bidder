package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Map;

/**
 * Created by Ankush on 26/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@Builder
public class Segment {

    @JsonProperty(value = "id")
    private final String id;

    @JsonProperty(value = "name")
    private final String name;

    @JsonProperty(value = "value")
    private final String value;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;


}
