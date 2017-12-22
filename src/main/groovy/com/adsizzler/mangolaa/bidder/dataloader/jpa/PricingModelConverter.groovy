package com.adsizzler.mangolaa.bidder.dataloader.jpa

import com.adsizzler.mangolaa.bidder.domain.enums.PricingModel

import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Created by ankushsharma on 27/09/17.
 */
@Converter(autoApply = true)
class PricingModelConverter implements AttributeConverter<PricingModel, Integer> {

    @Override
    Integer convertToDatabaseColumn(PricingModel pricingModel) {
        if(pricingModel){
            pricingModel.code
        }
    }

    @Override
     PricingModel convertToEntityAttribute(Integer dbData) {
        if(dbData != null){
            PricingModel.from(dbData)
        }
    }

}
