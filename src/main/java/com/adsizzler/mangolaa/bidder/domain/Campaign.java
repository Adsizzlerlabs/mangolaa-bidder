package com.adsizzler.mangolaa.bidder.domain;

import com.adsizzler.mangolaa.bidder.domain.enums.CampaignPhase;
import com.adsizzler.mangolaa.bidder.domain.enums.PricingModel;
import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Category;
import com.googlecode.cqengine.attribute.Attribute;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Set;

import static com.googlecode.cqengine.query.QueryFactory.attribute;

/**
 * Created by ankushsharma on 12/09/17.
 */
@Data
@Builder
public class Campaign {

    private final Integer id;
    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Status status;
    private final Set<Capping> cappings;

    //The advertiser this Campaign belongs to
    private final Integer advId;
    private final Set<Category> categorySet;
    private final String packageName;
    private final CampaignPhase campaignPhase;
    private final PricingModel pricingModel;
    private final Float bid;
    private final Float totalBudget;
    private final Float dailyBudget;
    private final String customData;

    private final Set<String> carriers;

    //For example :
    //To target city : city:state:country
    //To target state : state:country
    //To Target country : country
    private final Set<String> location;

    //no bid will be made for these app ids
    private final Set<String> blacklistedAppIds;


    //Bids will only be made for these app ids
    private final Set<String> whitelistedAppIds;

    //Also includes ip series For ex 11.x.x.x
    private final Set<String> blacklistedIps;

    private final Set<String> blacklistedUserAgents;


    public static final Attribute<Campaign,ChronoLocalDate> START_DATE = attribute(Campaign :: getStartDate);

    public static final Attribute<Campaign,ChronoLocalDate> END_DATE = attribute(Campaign :: getEndDate);

    public static final Attribute<Campaign,Status> STATUS = attribute(Campaign :: getStatus);

    public static final Attribute<Campaign,Integer> ADV_ID = attribute(Campaign :: getAdvId);

    public static final Attribute<Campaign,CampaignPhase> CAMPAIGN_PHASE = attribute(Campaign :: getCampaignPhase);

    public static final Attribute<Campaign,String> PACKAGE_NAME = attribute(Campaign :: getPackageName);

    public static final Attribute<Campaign,Set<String>> TARGETTED_CARRIERS = attribute(Campaign :: getCarriers);

    public static final Attribute<Campaign,Set<String>> TARGETTED_LOCATIONS = attribute(Campaign :: getLocation);

    public static final Attribute<Campaign,Set<String>> BLACKLISTED_IPS = attribute(Campaign :: getBlacklistedIps);

    public static final Attribute<Campaign,Set<String>> BLACKLISTED_USER_AGENTS = attribute(Campaign :: getBlacklistedUserAgents);

    public static final Attribute<Campaign,Set<String>> WHITELISTED_APP_IDS = attribute(Campaign :: getWhitelistedAppIds);

    public static final Attribute<Campaign,Set<String>> BLACKLISTED_APP_IDS = attribute(Campaign :: getBlacklistedAppIds);

}
