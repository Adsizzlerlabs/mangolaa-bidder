package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.ConnectionType;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.DeviceType;
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
public class Device {

    //Add pxratio,geofetch,language, mccmnc,ifa

    @JsonProperty(value = "ua")
    private final String userAgent;

    @JsonProperty(value = "geo")
    private final Geo geo;

    @JsonProperty(value = "dnt")
    private final Integer dontTrack;

    @JsonProperty(value = "lmt")
    private final Integer trackingRestricted;

    @JsonProperty(value = "ip")
    private final String ipv4;

    @JsonProperty(value = "ipv6")
    private final String ipv6;

    @JsonProperty(value = "devicetype")
    private final DeviceType deviceType;

    @JsonProperty(value = "make")
    private final String make;

    @JsonProperty(value = "model")
    private final String model;

    @JsonProperty(value = "os")
    private final String os;

    @JsonProperty(value = "osv")
    private final String osVersion;

    @JsonProperty(value = "h")
    private final String pixelsHeight;

    @JsonProperty(value = "w")
    private final String pixelWidth;

    @JsonProperty(value = "ppi")
    private final String screenSizeInches;

    @JsonProperty(value = "js")
    private final Integer javascriptSupported;

    @JsonProperty(value = "flashver")
    private final String flashVersion;

    @JsonProperty(value = "carrier")
    private final String carrier;

    @JsonProperty(value = "connectiontype")
    private final ConnectionType connectionType;

    @JsonProperty(value = "didsha1")
    private final String hardwareDeviceIdSha1;

    @JsonProperty(value = "dpidmd5")
    private final String hardwareDeviceIdMd5;

    @JsonProperty(value = "macsha1")
    private final String macAddressSha1;

    @JsonProperty(value = "macmd5")
    private final String macAddressMd5;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;


    @JsonIgnore
    public boolean isDontIgnore(){
        return Objects.equals(dontTrack,1);
    }

    @JsonIgnore
    public boolean isTrackingAllowed(){
        return Objects.equals(dontTrack,0);
    }

    @JsonIgnore
    public boolean isTrackingRestricted(){
        return Objects.equals(trackingRestricted,1);
    }

    @JsonIgnore
    public boolean isJavascriptSupported(){
        return Objects.equals(javascriptSupported,1);
    }

}
