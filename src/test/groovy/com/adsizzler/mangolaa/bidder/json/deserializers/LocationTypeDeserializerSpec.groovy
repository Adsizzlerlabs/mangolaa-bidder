package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.LocationType
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.LocationTypeDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 28/07/17.
 */
class LocationTypeDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup() {
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its LocationType enum repr "() {
        given:
            def json = new JsonBuilder([locationtype: intValue]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when:
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new LocationTypeDeserializer().deserialize(jsonParser, deserializationCtx)


        then:
            result == expectedResult

            where:
            intValue || expectedResult
            1        || LocationType.GPS_LOCATION_SERVICES
            2        || LocationType.IP_ADDRESS
            3        || LocationType.USER_PROVIDED
            null     || LocationType.UNKNOWN

    }

}