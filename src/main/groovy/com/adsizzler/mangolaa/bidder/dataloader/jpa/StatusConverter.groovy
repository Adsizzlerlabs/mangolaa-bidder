package com.adsizzler.mangolaa.bidder.dataloader.jpa

import com.adsizzler.mangolaa.bidder.domain.Status

import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Created by ankushsharma on 27/09/17.
 */
@Converter(autoApply = true)
class StatusConverter implements AttributeConverter<Status,Integer>{

    @Override
    Integer convertToDatabaseColumn(Status status) {
        if(status){
            status.code
        }
    }

    @Override
    Status convertToEntityAttribute(Integer dbData) {
        // Don't use if(dbData) here, because then if dbData = 0, then the condition would evaluate to true
        if(dbData != null){
            Status.from(dbData)
        }
    }

}

