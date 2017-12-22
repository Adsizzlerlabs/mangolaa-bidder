package com.adsizzler.mangolaa.bidder.domain.openrtb.request;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.AuctionType;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Category;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Currency;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Mode;
import com.adsizzler.mangolaa.bidder.util.Strings;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import lombok.val;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Ankush on 17/07/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
@ToString
public class BidRequest {

    @JsonProperty(value = "id", required = true)
    private final String id;

    @JsonProperty(value = "imp", required = true)
    private final Set<ImpressionRequest> impressionRequests;

    @JsonProperty(value = "test")
    private final Mode mode;

    @JsonProperty(value = "tmax")
    private final Short maxTimeToRespond;

    @JsonProperty(value = "wseat")
    private final Set<String> whitelistedAdvertisers;

    @JsonProperty(value = "bseat")
    private final Set<String> blacklistedAdvertisers;

    @JsonProperty(value = "cur")
    private final Set<Currency> currencies;

    @JsonProperty(value = "wlang")
    private final Set<String> whitelistedLanguages;

    @JsonProperty(value = "badv")
    private final Set<String> blockedAdvDomains;

    @JsonProperty(value = "bapp")
    private final Set<String> blockedApps;

    @JsonProperty(value = "source")
    private final Source source;

    @JsonProperty(value = "regs")
    private final Regulations regulations;

    @JsonProperty(value = "at")
    private final AuctionType auctionType;

    @JsonProperty(value = "allimps")
    private final Integer allImps;

    @JsonProperty(value = "bcat")
    private final Set<Category> blockedCategories;

    @JsonProperty(value = "ext")
    private final Map<String,Object> extensions;

    @JsonProperty(value = "device")
    private final Device device;

    @JsonProperty(value = "user")
    private final User user;


    @JsonIgnore
    public boolean forAllImps(){
        return Objects.equals(allImps,1);
    }

    @JsonIgnore
    public boolean hasExtensions(){
        return Objects.isNull(extensions);
    }

    public Set<String> getWhitelistedAdvertisers(){
        if(Objects.isNull(whitelistedAdvertisers)){
            return Collections.emptySet();
        }
        return whitelistedAdvertisers;
    }

    public Set<Currency> getCurrencies(){
        if(Objects.isNull(currencies)){
            return Collections.emptySet();
        }
        return currencies;
    }

    public Set<ImpressionRequest> getImpressionRequests(){
        if(Objects.isNull(impressionRequests)){
            return Collections.emptySet();
        }
        return impressionRequests;
    }

    public Set<Category> getBlockedCategories(){
        if(Objects.isNull(blockedCategories)){
            return Collections.emptySet();
        }
        return blockedCategories;
    }

    public Set<String> getBlockedApps(){
        if(Objects.isNull(blockedApps)){
            return Collections.emptySet();
        }
        return blockedApps;
    }

    public Set<String> getBlacklistedAdvertisers(){
        if(Objects.isNull(blacklistedAdvertisers)){
            return Collections.emptySet();
        }
        return blacklistedAdvertisers;
    }

    public Set<String> getBlockedAdvDomains(){
        if(Objects.isNull(blockedAdvDomains)){
            return Collections.emptySet();
        }
        return blockedAdvDomains;
    }

    public Set<String> getWhitelistedLanguages(){
        if(Objects.isNull(whitelistedLanguages)){
            return Collections.emptySet();
        }
        return whitelistedLanguages;
    }


    @JsonIgnore
    public String getIp(){
        String result = "";
        val device = getDevice();
        if(!Objects.isNull(device)){
            val ipv4 = device.getIpv4();
            val ipv6 = device.getIpv6();
            if(!Strings.hasText(ipv4)){
                result = ipv6;
            }
            else{
                result = ipv4;
            }
        }
        return result;
    }
}
