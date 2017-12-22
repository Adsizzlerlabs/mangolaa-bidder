package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Ankush on 18/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Metric {

    @JsonProperty(value = "type", required = true)
    private final String type;

    @JsonProperty(value = "value", required = true)
    private final Float value;

    @JsonProperty("vendor")
    private final String vendor;

    @JsonProperty("ext")
    private final Map<String,Object> extensions;

}
