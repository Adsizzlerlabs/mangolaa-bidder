package com.adsizzler.mangolaa.bidder.service;

import io.vertx.core.Future;

/**
 * Created by ankushsharma on 12/09/17.
 */
public interface JsonService {

    <T> Future<T> toObject(String json, Class<T> clazz);

    <T> Future<String> toJson(T t);

    <T> Future<String> toPrettyJson(T t);
}
