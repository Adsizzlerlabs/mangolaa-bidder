package com.adsizzler.mangolaa.bidder.json.jackson.deserializers;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.CreativeAttributes;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by Ankush on 19/07/17.
 */
public class CreativeAttributesDeserializer extends JsonDeserializer<CreativeAttributes> {

    @Override
    public CreativeAttributes deserialize(
            final JsonParser parser,
            final DeserializationContext ctxt
    ) throws IOException
    {
        return CreativeAttributes.from(parser.getValueAsInt());
    }
}
