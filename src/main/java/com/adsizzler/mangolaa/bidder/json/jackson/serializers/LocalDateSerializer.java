package com.adsizzler.mangolaa.bidder.json.jackson.serializers;


import com.adsizzler.mangolaa.bidder.util.Dates;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Ankush on 17/07/17.
 */
public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(
            final LocalDate date,
            final JsonGenerator gen,
            final SerializerProvider serializers
    ) throws IOException
    {
        if(Objects.nonNull(date)){
            gen.writeString(Dates.asIsoString(date));
        }
    }

}
