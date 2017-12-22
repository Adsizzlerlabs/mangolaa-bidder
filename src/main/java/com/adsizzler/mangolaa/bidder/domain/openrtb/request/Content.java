package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Set;

/**
 * Created by Ankush on 26/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Content {

    @JsonProperty(value = "id")
    private final String id;

    @JsonProperty(value = "episode")
    private final Integer episode;

    @JsonProperty(value = "title")
    private final String title;

    @JsonProperty(value = "series")
    private final String series;

    @JsonProperty(value = "season")
    private final String season;

    @JsonProperty(value = "artist")
    private final String artist;

    @JsonProperty(value = "genre")
    private final String genre;

    @JsonProperty(value = "album")
    private final String album;

    @JsonProperty(value = "isrc")
    private final String isrc;

    @JsonProperty(value = "producer")
    private final Producer producer;

    @JsonProperty(value = "url")
    private final String url;

    @JsonProperty(value = "cat")
    private final Set<Category> categories;

    @JsonProperty(value = "prodq")
    private final ProductionQuality productionQuality;

    @JsonProperty(value = "context")
    private final Context context;

    @JsonProperty(value = "contentrating")
    private final String contentRating;

    @JsonProperty(value = "userrating")
    private final String userRating;

    @JsonProperty(value = "qagmediarating")
    private final MediaRating mediaRating;

    @JsonProperty(value = "keywords")
    private final String keywords;

    @JsonProperty(value = "sourcerelationship")
    private final SourceRelationship sourceRelationship;

    @JsonProperty(value = "embeddable")
    private final Integer embeddable;

    @JsonProperty(value = "data")
    private final Set<Data> data;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;


    //Add Language
}
