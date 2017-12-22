package com.adsizzler.mangolaa.bidder.json.jackson.deserializers;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.ConnectionType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by Ankush on 27/07/17.
 */
public class ConnectionTypeDeserializer extends JsonDeserializer<ConnectionType> {

    @Override
    public ConnectionType deserialize(
            final JsonParser parser,
            final DeserializationContext ctxt
    ) throws IOException
    {
        return ConnectionType.from(parser.getValueAsInt());
    }

}
