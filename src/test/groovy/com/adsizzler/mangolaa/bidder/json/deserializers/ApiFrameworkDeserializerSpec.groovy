package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.ApiFrameworks
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.ApiFrameworkDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 27/07/17.
 */
class ApiFrameworkDeserializerSpec extends BaseSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its ApiFramework enum repr "(){
        given :
            def json = new JsonBuilder([ api : intValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new ApiFrameworkDeserializer().deserialize(jsonParser,deserializationCtx)

        then :
            result  == expectedResult

        where:
             intValue || expectedResult
                    1 || ApiFrameworks.VPAID_1_0
                    2 || ApiFrameworks.VPAID_2_0
                    3 || ApiFrameworks.MRAID_1
                    4 || ApiFrameworks.ORMMA
                    5 || ApiFrameworks.MRAID_2
                    6 || ApiFrameworks.MRAID_3
                  null|| ApiFrameworks.UNKNOWN
    }
}
