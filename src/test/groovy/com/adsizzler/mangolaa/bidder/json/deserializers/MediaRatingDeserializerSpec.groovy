package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.MediaRating
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.MediaRatingDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 28/07/17.
 */
class MediaRatingDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup() {
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve string value to its MediaRating enum repr "() {
        given:
            def json = new JsonBuilder([mediarating: intValue]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when:
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new MediaRatingDeserializer().deserialize(jsonParser, deserializationCtx)


        then:
            result == expectedResult

            where:
            intValue  || expectedResult
            1         || MediaRating.ALL_AUDIENCES
            2         || MediaRating.EVERYONE_OVER_12
            3         || MediaRating.MATURE_AUDIENCES
            null      || MediaRating.UNKNOWN

    }


}