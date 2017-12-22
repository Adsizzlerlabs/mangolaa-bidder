package com.adsizzler.mangolaa.bidder.json.jackson.deserializers;

import com.adsizzler.mangolaa.bidder.util.Strings;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.val;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Ankush on 17/07/17.
 */
public class LocalDateDeserializer  extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(
            final JsonParser parser,
            final DeserializationContext ctxt
    ) throws IOException
    {
        val text = parser.getValueAsString();
        LocalDate result = null;
        if(Strings.hasText(text)){
            result = LocalDate.parse(
                    parser.getValueAsString(),
                    DateTimeFormatter.ISO_DATE
            );
        }
        return result;
    }
}
