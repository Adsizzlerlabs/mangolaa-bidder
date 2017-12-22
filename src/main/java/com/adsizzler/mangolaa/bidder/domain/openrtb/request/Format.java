package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Ankush on 19/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Format {

    @JsonProperty(value = "w")
    private final Integer width;

    @JsonProperty(value = "h")
    private final Integer height;

    @JsonProperty(value = "wratio")
    private final Integer relativeWidth;

    @JsonProperty(value = "hratio")
    private final Integer relativeHeight;

    @JsonProperty(value = "wmin")
    private final Integer minWidth;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;
}
