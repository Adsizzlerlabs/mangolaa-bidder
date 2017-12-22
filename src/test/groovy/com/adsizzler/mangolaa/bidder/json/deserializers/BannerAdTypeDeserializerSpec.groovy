package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.BannerAdType
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.BannerAdTypeDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 27/07/17.
 */
class BannerAdTypeDeserializerSpec extends BaseSpec {
    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve string value to its BannerAdType enum repr. Default value is BannerAdType.UNKNOWN  "(){
        given :
            def json = new JsonBuilder([at: intValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new BannerAdTypeDeserializer().deserialize(jsonParser,deserializationCtx)

        then :
            result  == expectedResult

        where:
            intValue    || expectedResult
            1           || BannerAdType.XHTML_TEXT
            2           || BannerAdType.XHTML_BANNER
            3           || BannerAdType.JAVASCRIPT
            4           || BannerAdType.IFRAME
            null        || BannerAdType.UNKNOWN // Default value
    }
}
