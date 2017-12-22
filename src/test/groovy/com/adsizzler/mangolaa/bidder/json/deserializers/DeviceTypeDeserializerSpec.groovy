package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.DeviceType
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.DeviceTypeDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 28/07/17.
 */
class DeviceTypeDeserializerSpec extends BaseSpec{

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve int value to its DeviceType enum repr "(){
        given :
            def json = new JsonBuilder([deviceType: intValue ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new DeviceTypeDeserializer().deserialize(jsonParser,deserializationCtx)


        then :
            result  == expectedResult

            where:
            intValue   || expectedResult
             1         ||  DeviceType.MOBILE_TABLET
             2         ||  DeviceType.PERSONAL_COMPUTER
             3         ||  DeviceType.TV
             4         ||  DeviceType.PHONE
             5         ||  DeviceType.TABLET
             6         ||  DeviceType.CONNECTED_DEVICE
             7         ||  DeviceType.SET_TOP_BOX
            null       ||  DeviceType.UNKNOWN
    }

}
