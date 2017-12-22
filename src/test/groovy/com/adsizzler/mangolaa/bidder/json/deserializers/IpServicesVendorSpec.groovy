package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.IpServicesVendor
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.IpServicesVendorDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 01/08/17.
 */
class IpServicesVendorSpec extends BaseSpec{

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve string value to its IpServicesVendor enum repr "(){
        given :
            def json = new JsonBuilder([ipservendor: intValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new IpServicesVendorDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

            where:
            intValue  || expectedResult
               1      ||  IpServicesVendor.QUOVA
               2      ||  IpServicesVendor.MAXMIND
               3      ||  IpServicesVendor.DIGITAL_ELEMENT
               null   ||  IpServicesVendor.UNKNOWN

    }
}
