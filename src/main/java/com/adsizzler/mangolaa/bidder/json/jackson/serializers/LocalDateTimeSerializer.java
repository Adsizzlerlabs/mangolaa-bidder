package com.adsizzler.mangolaa.bidder.json.jackson.serializers;

import com.adsizzler.mangolaa.bidder.util.Dates;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by Ankush on 17/07/17.
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(
            final LocalDateTime dateTime,
            final JsonGenerator gen,
            final SerializerProvider serializers
    ) throws IOException
    {
        if(Objects.nonNull(dateTime)){
            gen.writeString(Dates.asIsoString(dateTime));
        }
    }

}
