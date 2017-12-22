package com.adsizzler.mangolaa.bidder.dataloader.jpa

import com.adsizzler.mangolaa.bidder.dataloader.domain.CampaignFreqCap

import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Created by ankushsharma on 30/11/17.
 */
@Converter(autoApply = true)
class TimeUnitJpaConverter implements AttributeConverter<CampaignFreqCap.TimeUnit,Integer> {

    @Override
    Integer convertToDatabaseColumn(CampaignFreqCap.TimeUnit attribute) {
        if(attribute){
            attribute.code
        }
    }

    @Override
    CampaignFreqCap.TimeUnit convertToEntityAttribute(Integer dbData) {
        if(Objects.nonNull(dbData)){
            CampaignFreqCap.TimeUnit.from(dbData)
        }
    }
}
