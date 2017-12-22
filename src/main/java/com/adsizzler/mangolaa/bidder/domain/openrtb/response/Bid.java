package com.adsizzler.mangolaa.bidder.domain.openrtb.response;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * Created by Ankush on 04/08/17.
 */
@Data
@Builder
public class Bid {

    @JsonProperty(value = "id", required = true)
    private final String id;

    @JsonProperty(value = "impid", required = true)
    private final String impressionId;

    @JsonProperty(value = "price", required = true)
    private final Float price;

    @JsonProperty("nurl")
    private final String winUrl;

    @JsonProperty("burl")
    private final String billingUrl;

    @JsonProperty("lurl")
    private final String lossUrl;

    @JsonProperty("adm")
    private final String adMarkup;

    @JsonProperty("crid")
    private final String adId;

    @JsonProperty("adomain")
    private final Set<String> advDomain;

    @JsonProperty("bundle")
    private final String bundle;

    @JsonProperty("cid")
    private final String campaignId;

    @JsonProperty("tactic")
    private final String tacticId;

    @JsonProperty("cat")
    private final Set<Category> categories;

    @JsonProperty("attr")
    private final Set<CreativeAttributes> creativeAttributes;

    @JsonProperty("api")
    private final ApiFrameworks apiFramework;

    @JsonProperty("protocol")
    private final BidResponseProtocol bidResponseProtocol;

    @JsonProperty("qagmediarating")
    private final MediaRating mediaRating;

    @JsonProperty("exp")
    private final Integer expiration;

    @JsonProperty("dealid")
    private final String dealId;

    @JsonProperty("w")
    private final Integer width;

    @JsonProperty("h")
    private final Integer height;

    @JsonProperty("wratio")
    private final Integer widthRatio;

    @JsonProperty("hratio")
    private final Integer heightRatio;

    @JsonProperty("ext")
    private final Map<String,Object> extensions;

    //Add iurl,language



}
