package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Set;

/**
 * Created by Ankush on 26/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Producer {

    @JsonProperty(value = "id")
    private final String id;

    @JsonProperty(value = "name")
    private final String name;

    @JsonProperty(value = "cat")
    private final Set<Category> categories;

    @JsonProperty(value = "domain")
    private final String domain;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;

}
