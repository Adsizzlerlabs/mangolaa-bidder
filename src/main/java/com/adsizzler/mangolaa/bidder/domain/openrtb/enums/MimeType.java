package com.adsizzler.mangolaa.bidder.domain.openrtb.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.experimental.var;
import lombok.val;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Ankush on 26/07/17.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown =  true)
public enum MimeType  {

    UNKNOWN("Unknown"),
    APPLICATION_JAVASCRIPT("application/javascript"),
    APPLICATION_JSON("application/json"),
    APPLICATION_X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded"),
    APPLICATION_XML("application/xml"),
    APPLICATION_ZIP("application/msword"),
    APPLICATION_PDF("application/pdf"),
    APPLICATION_MSWORD("application/msword"),
    APPLICATION_VND_MS_EXCEL("application/vnd.ms-excel"),
    APPLICATION_VND_OPENXMLFORMATS_OFFICE_DOCUMENTS_SPREADSHEETML_SHEET("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    APPLICATION_SQL("application/sql"),
    APPLICATION_VND_MS_POWERPOINT("application/vnd.ms-powerpoint"),
    APPLICATION_VND_OPENXMLFORMATS_OFFICE_DOCUMENT_PRESENTATIONML_PRESENTATION("application/vnd.openxmlformats-officedocument.presentationml.presentation"),
    AUDIO_MPEG("audio/mpeg"),
    AUDIO_VORBIS("audio/vorbis"),
    MULTIPART_FORM_DATA("multipart/form-data"),
    TEXT_CSS("text/css"),
    TEXT_HTML("text/html"),
    TEXT_CSV("text/csv"),
    TEXT_PLAIN("text/plain"),
    IMAGE_PNG("image/png"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_GIF("image/gif");

    private final String description;

    MimeType(final String description){
        this.description = description;
    }

    private static final Map<String,MimeType> CACHE ;

    static{
        //Populate the cache on startup
        val tempMap = new HashMap<String,MimeType>();
        for(val mimeType : MimeType.values()){
            tempMap.put(mimeType.getDescription(), mimeType);
        }
        CACHE = ImmutableMap.copyOf(tempMap);
    }

    public static MimeType from(final String description){
        var result = CACHE.get(description);
        if(Objects.isNull(result)){
            result = UNKNOWN;
        }
        return result;
    }

}
