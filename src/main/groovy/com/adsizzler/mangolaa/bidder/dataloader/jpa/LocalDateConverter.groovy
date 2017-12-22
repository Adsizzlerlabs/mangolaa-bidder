package com.adsizzler.mangolaa.bidder.dataloader.jpa

import javax.persistence.AttributeConverter
import javax.persistence.Converter
import java.sql.Date
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

/**
 * Created by ankushsharma on 27/09/17.
 */
@Converter(autoApply = true)
class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    Date convertToDatabaseColumn(LocalDate localDate) {
        if(localDate){
            Date.from(Instant.from(localDate).atZone(ZoneId.of("Asia/Kolkata")).toLocalDate())
        }
    }

    @Override
    LocalDate convertToEntityAttribute(Date dbData) {
        if(dbData){
            dbData.toLocalDate()
        }
    }
}