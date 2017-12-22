package com.adsizzler.mangolaa.bidder.json.jackson.deserializers;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.IpServicesVendor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by Ankush on 01/08/17.
 */
public class IpServicesVendorDeserializer extends JsonDeserializer<IpServicesVendor> {

    @Override
    public IpServicesVendor deserialize(
            final JsonParser parser,
            final DeserializationContext ctxt
    ) throws IOException
    {
        return IpServicesVendor.from(parser.getValueAsInt());
    }
}
