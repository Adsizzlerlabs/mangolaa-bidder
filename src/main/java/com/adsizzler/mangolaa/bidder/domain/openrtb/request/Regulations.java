package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * Created by Ankush on 18/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Regulations {

    @JsonProperty(value = "coppa")
    private final Integer coppa;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;

    @JsonIgnore
    public boolean isSubjectToRegulations(){
        return Objects.equals(coppa,1);
    }

}
