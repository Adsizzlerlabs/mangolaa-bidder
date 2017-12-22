package com.adsizzler.mangolaa.bidder.json.jackson.deserializers;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.BannerAdType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by Ankush on 19/07/17.
 */
public class BannerAdTypeDeserializer extends JsonDeserializer<BannerAdType> {

    @Override
    public BannerAdType deserialize(
            final JsonParser parser,
            final DeserializationContext ctxt
    ) throws IOException
    {
        return BannerAdType.from(parser.getValueAsInt());
    }

}
