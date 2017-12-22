package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.*;
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
public class Banner {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("format")
    private final Set<Format> formats;

    @JsonProperty("w")
    private final Integer width;

    @JsonProperty("h")
    private final Integer height;

    @JsonProperty("btype")
    private final Set<BannerAdType> blockedAdTypes;

    @JsonProperty("battr")
    private final Set<CreativeAttributes> blockedCreativesTypes;

    @JsonProperty("pos")
    private final AdPosition adPosition;

    @JsonProperty("mimes")
    private final Set<MimeType> mimeTypes;

    @JsonProperty("topframe")
    private final Integer topFrame;

    @JsonProperty("expdir")
    private final Set<ExpandableDirection> expandableDirections;

    @JsonProperty("ext")
    private final Map<String,Object> extensions;

    @JsonIgnore
    public boolean isTopFrame(){
        return Objects.equals(topFrame,1);
    }
}
