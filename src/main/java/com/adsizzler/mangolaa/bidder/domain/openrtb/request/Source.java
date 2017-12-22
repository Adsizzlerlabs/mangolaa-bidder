package com.adsizzler.mangolaa.bidder.domain.openrtb.request;


import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.ImpressionEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Ankush on 18/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Source {

    @JsonProperty(value = "fd")
    private final ImpressionEntity entity;

    @JsonProperty(value = "tid")
    private final String transactionId;

    @JsonProperty(value = "pchain")
    private final String paymentId;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;

}
