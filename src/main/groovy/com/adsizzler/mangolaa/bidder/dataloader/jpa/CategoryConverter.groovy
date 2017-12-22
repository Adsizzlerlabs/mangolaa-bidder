package com.adsizzler.mangolaa.bidder.dataloader.jpa

import com.adsizzler.mangolaa.bidder.domain.openrtb.enums.Category
import com.adsizzler.mangolaa.bidder.util.Strings

import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Created by ankushsharma on 27/09/17.
 */
@Converter(autoApply = true)
class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    String convertToDatabaseColumn(Category category) {
        if(category){
            category.code
        }
    }

    @Override
    Category convertToEntityAttribute(String dbData) {
        if(Strings.hasText(dbData)){
            Category.from(dbData)
        }
    }
}
