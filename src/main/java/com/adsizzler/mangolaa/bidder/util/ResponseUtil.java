package com.adsizzler.mangolaa.bidder.util;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.http.HttpServerResponse;

/**
 * Created by ankushsharma on 13/09/17.
 */
public class ResponseUtil {

    public static void buildResponse(
            final String json,
            final HttpServerResponse httpResp
    )
    {
        PreConditions.notNull(httpResp,"httpResp cannot be null");
        PreConditions.notNull(json,"json cannot be null");

        httpResp.putHeader("Connection","keep-alive");

        if(!Strings.hasText(json)){
            httpResp.setStatusCode(HttpResponseStatus.NO_CONTENT.code())
                    .end();
        }
        else{
            httpResp.setStatusCode(HttpResponseStatus.OK.code())
                    .setChunked(true)
                    .end(json);
        }
    }
}
