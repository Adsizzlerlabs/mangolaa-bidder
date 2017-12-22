package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Category;
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
public class App {

    @JsonProperty(value = "id")
    private final String id;

    @JsonProperty(value = "name")
    private final String name;

    @JsonProperty(value = "bundle")
    private final String bundle;

    @JsonProperty(value = "domain")
    private final String domain;

    @JsonProperty(value = "storeurl")
    private final String storeUrl;

    @JsonProperty(value = "cat")
    private final Set<Category> categories;

    @JsonProperty(value = "sectioncat")
    private final Set<Category> sectionCategories; // What is this?

    @JsonProperty(value = "pagecat")
    private final Set<Category> pageCategories;

    @JsonProperty(value = "pagecat")
    private final String version;

    @JsonProperty(value = "privacypolicy")
    private final Integer privacyPolicy;

    @JsonProperty(value = "pagecat")
    private final Integer paid;

    @JsonProperty(value = "keywords")
    private final String keywords;

    @JsonProperty(value = "publisher")
    private final Publisher publisher;

    @JsonProperty(value = "content")
    private final Content content;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;

    @JsonIgnore
    public boolean hasPrivacyPolicy(){
        return Objects.equals(privacyPolicy,1);
    }

    @JsonIgnore
    public boolean isPaidVersion(){
        return Objects.equals(paid,1);
    }

    @JsonIgnore
    public boolean hasExtensions(){
        return Objects.isNull(extensions);
    }

}
