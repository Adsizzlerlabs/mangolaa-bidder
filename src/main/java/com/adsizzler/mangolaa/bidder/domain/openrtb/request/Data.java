package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Map;
import java.util.Set;

/**
 * Created by Ankush on 26/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@Builder
public class Data {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("segment")
    private final Set<Segment> segments;

    @JsonProperty("ext")
    private final Map<String,Object> extensions;


}

