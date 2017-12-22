package com.adsizzler.mangolaa.bidder.json.jackson.serializers;

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.CreativeAttributes;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by Ankush on 08/08/17.
 */
public class CreativeAttributesSerializer extends JsonSerializer<CreativeAttributes> {

    @Override
    public void serialize(
            final CreativeAttributes creativeAttributes,
            final JsonGenerator gen,
            final SerializerProvider serializers
    ) throws IOException
    {
        if(Objects.nonNull(creativeAttributes)){
            gen.writeNumber(creativeAttributes.getCode());
        }
    }
}
