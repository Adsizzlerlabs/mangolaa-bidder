package com.adsizzler.mangolaa.bidder.service.impl;

import com.adsizzler.mangolaa.bidder.constants.RedisKeys;
import com.adsizzler.mangolaa.bidder.domain.openrtb.request.User;
import com.adsizzler.mangolaa.bidder.service.ImpressionCountService;
import com.adsizzler.mangolaa.bidder.util.Dates;
import com.adsizzler.mangolaa.bidder.util.PreConditions;
import com.adsizzler.mangolaa.bidder.util.Strings;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.api.rx.RedisHashReactiveCommands;
import io.vertx.core.Future;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import static com.adsizzler.mangolaa.bidder.util.ExceptionUtil.shortDescription;

/**
 * Created by ankushsharma on 03/10/17.
 */
@Service
@Slf4j
public class ImpressionCountServiceImpl implements ImpressionCountService {

    private static final Integer ZERO_COUNT = 0;
    private static final String ZERO_COUNT_STRING = String.valueOf(ZERO_COUNT);

    private final StatefulRedisConnection<String,String> redisConn;

    public ImpressionCountServiceImpl(final StatefulRedisConnection<String,String> redisConn){
        this.redisConn = redisConn;
    }

    @Override
    public Future<Integer> getDailyCount(
            final User user,
            final Integer campaignId
    )
    {
        PreConditions.notNull(campaignId,  "campaignId cannot be null");
        PreConditions.notNull(user,  "user cannot be null");

        val today = Dates.utcNow().toLocalDate();
        val redisKey =  RedisKeys.USER_IMPRESSION_COUNT_DAILY_HASH_KEY;
        val redisValue = RedisKeys.buildUserImpressionDailyCountHashField(campaignId,user.getId(), today);
        return getCountFuture(redisKey,redisValue);
    }

    @Override
    public Future<Integer> getTotalCount(
            final User user,
            final Integer campaignId
    )
    {
        PreConditions.notNull(campaignId,  "campaignId cannot be null");
        PreConditions.notNull(user,  "user cannot be null");

        val redisKey =  RedisKeys.USER_IMPRESSION_COUNT_TOTAL_HASH_KEY;
        val redisValue = RedisKeys.buildUserImpressionTotalCountHashField(campaignId,user.getId());
        return getCountFuture(redisKey,redisValue);
    }

    private Future<Integer> getCountFuture(
        final String redisKey,
        final String redisValue
    )
    {
        // No need for Assertions, as these fields are guaranteed to be non null and non empty
        val future = Future.<Integer>future();
        try {
            final RedisHashReactiveCommands<String, String> commands = redisConn.reactive();
            commands.hget(
                    redisKey,
                    redisValue
            )
            .defaultIfEmpty(ZERO_COUNT_STRING)
            .doOnError(error -> {
                future.complete(ZERO_COUNT);
                log.error(shortDescription(error));
            })
            .subscribe(result -> {
                val count = getCount(result);
                future.complete(count);
            });

        } catch (final Exception ex) {
            log.error("", ex);
            future.complete(ZERO_COUNT);
        }
        return future;
    }

    private static Integer getCount(final String str){
        if(!Strings.hasText(str)){
            return 0;
        }
        return Integer.valueOf(str);
    }
}
