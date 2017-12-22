package com.adsizzler.mangolaa.bidder.constants;

import com.adsizzler.mangolaa.bidder.util.Dates;
import com.adsizzler.mangolaa.bidder.util.PreConditions;

import java.time.LocalDate;

/**
 * Created by ankushsharma on 03/10/17.
 */
public class RedisKeys {

    public static final String USER_IMPRESSION_COUNT_TOTAL_HASH_KEY = "t";
    public static final String USER_IMPRESSION_COUNT_TOTAL_HASH_FIELD_TEMPLATE = "<camp_id>:<user_id>";

    public static final String USER_IMPRESSION_COUNT_DAILY_HASH_KEY = "d";
    public static final String USER_IMPRESSION_COUNT_DAILY_HASH_FIELD_TEMPLATE = "<camp_id>:<user_id>:<date_stamp>";


    public static String buildUserImpressionTotalCountHashField(
        final Integer campaignId,
        final String userId
    )
    {
        PreConditions.notNull(campaignId,"campaignId cannot be null");
        PreConditions.notEmptyString(userId,"userId cannot be null or empty");
        return USER_IMPRESSION_COUNT_TOTAL_HASH_FIELD_TEMPLATE
                .replace("<camp_id>", String.valueOf(campaignId))
                .replace("<user_id>", userId);

    }

    public static String buildUserImpressionDailyCountHashField(
            final Integer campaignId,
            final String userId,
            final LocalDate date
            )
    {
        PreConditions.notNull(campaignId,"campaignId cannot be null");
        PreConditions.notEmptyString(userId,"userId cannot be null or empty");

        return USER_IMPRESSION_COUNT_DAILY_HASH_FIELD_TEMPLATE
                .replace("<camp_id>", String.valueOf(campaignId))
                .replace("<date_stamp>", Dates.asIsoString(date))
                .replace("<user_id>", userId);

    }


}
