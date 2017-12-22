package com.adsizzler.mangolaa.bidder.json.jackson.deserializers;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Category;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by Ankush on 19/07/17.
 */
public class CategoryDeserializer extends JsonDeserializer<Category> {

    @Override
    public Category deserialize(
            final JsonParser parser,
            final DeserializationContext ctxt
    )throws IOException
    {
        return Category.from(parser.getValueAsString());
    }
}
