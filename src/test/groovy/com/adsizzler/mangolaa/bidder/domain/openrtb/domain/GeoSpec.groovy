package com.adsizzler.mangolaa.commons.domain.openrtb.domain

import com.adsizzler.mangolaa.commons.BaseSpec
import com.adsizzler.mangolaa.commons.domain.openrtb.enums.LocationType
import com.adsizzler.mangolaa.commons.domain.openrtb.request.Geo
import com.adsizzler.mangolaa.commons.json.Json

/**
 * Created by Ankush on 08/08/17.
 */
class GeoSpec extends BaseSpec{

    String json
    float lat,lng
    def type,accuracy,lastfix,ipVendor,country,metroCode,city,zipCode,utcOffset,region

    def setup(){
        lat = 26.638
        lng = -44.21
        type = 2
        lastfix = 12
        ipVendor = 3
        country = "India"
        metroCode = "123"
        city = "Delhi"
        zipCode = '110049'
        utcOffset = 5
        region = "Delhi"


        json  =
                """
                 {
                      "country":"$country",
                      "lat": $lat,
                      "lon":$lng,
                      "city":"$city",
                      "zip":"$zipCode",
                      "region":"$region",
                      "type":$type,
                      "utcoffset": $utcOffset,
                      "ipservice": $ipVendor,
                      "lastfix" : $lastfix,
                      "accuracy" : $accuracy,
                      "type": $type
                }                
                """
    }

    def "JSON string to Segment POJO"(){

        when :
            def result = Json.toObject(json, Geo)

        then :
            result.with {
                country == country
                lat == lat
                lng == lng
                region == region
                city == city
                zipCode == zipCode
                locationType == LocationType.from(type)
                accuracy == accuracy
                lastFix == lastfix
                utcOffset == utcOffset

            }
    }

}
