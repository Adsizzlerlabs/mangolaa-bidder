package com.adsizzler.mangolaa.bidder.json.jackson.deserializers;

import com.adsizzler.mangolaa.bidder.util.Strings;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.val;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Ankush on 17/07/17.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(
            final JsonParser parser,
            final DeserializationContext ctxt
    ) throws IOException
    {
        val text = parser.getValueAsString();
        LocalDateTime result = null;
        if(Strings.hasText(text)){
            result = LocalDateTime.parse(
                    parser.getValueAsString(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );
        }
        return result;
    }

}
