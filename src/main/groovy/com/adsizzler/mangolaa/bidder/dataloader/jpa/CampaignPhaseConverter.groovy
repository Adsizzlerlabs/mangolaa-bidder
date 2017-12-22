package com.adsizzler.mangolaa.bidder.dataloader.jpa

import com.adsizzler.mangolaa.bidder.domain.enums.CampaignPhase

import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Created by ankushsharma on 30/11/17.
 */
@Converter(autoApply = true)
class CampaignPhaseConverter implements AttributeConverter<CampaignPhase, Integer> {

    @Override
    Integer convertToDatabaseColumn(CampaignPhase attribute) {
        if(attribute){
            attribute.code
        }
    }

    @Override
    CampaignPhase convertToEntityAttribute(Integer dbData) {
        if(Objects.nonNull(dbData)){
            CampaignPhase.from(dbData)
        }
    }

}
