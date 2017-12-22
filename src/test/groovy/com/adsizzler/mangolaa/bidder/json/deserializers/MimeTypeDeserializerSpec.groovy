package com.adsizzler.mangolaa.commons.json.deserializers

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.MimeType
import com.adsizzler.mangolaa.commons.json.jackson.deserializers.MimeTypeDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

/**
 * Created by Ankush on 28/07/17.
 */
class MimeTypeDeserializerSpec extends BaseSpec{

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup() {
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "resolve string value to its MimeType enum repr "() {

        given:
            def json = new JsonBuilder([mimetype: strValue]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when:
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new MimeTypeDeserializer().deserialize(jsonParser, deserializationCtx)


        then:
            result == expectedResult

        where:
            strValue                  || expectedResult
            "application/javascript"  || MimeType.APPLICATION_JAVASCRIPT
            "application/json"        || MimeType.APPLICATION_JSON
            "application/xml"         || MimeType.APPLICATION_XML
            null                      || MimeType.UNKNOWN

    }

}
