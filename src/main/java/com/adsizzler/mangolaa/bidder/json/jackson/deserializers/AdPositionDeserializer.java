package com.adsizzler.mangolaa.bidder.json.jackson.deserializers;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.AdPosition;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by Ankush on 01/08/17.
 */
public class AdPositionDeserializer extends JsonDeserializer<AdPosition> {

    @Override
    public AdPosition deserialize(
            final JsonParser parser,
            final DeserializationContext ctxt
    )throws IOException
    {
        return AdPosition.from(parser.getValueAsInt());
    }

}
