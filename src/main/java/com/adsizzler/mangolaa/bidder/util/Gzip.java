package com.adsizzler.mangolaa.bidder.util;


import com.adsizzler.mangolaa.bidder.exception.GzipException;
import lombok.val;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * Created by Ankush on 19/07/17.
 */
public class Gzip {

    private Gzip(){}


    public static byte[] compress(final String str) {

        if (!Strings.hasText(str)) {
            throw new IllegalArgumentException("Cannot zip null or empty string");
        }

        try (val byteArrayOutputStream = new ByteArrayOutputStream()) {
            try (val gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
                gzipOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            }
            return byteArrayOutputStream.toByteArray();
        }
        catch(final IOException e) {
            throw new GzipException("Failed to zip content");
        }
    }

    public static String decompress(final byte[] compressed) {

        if ((compressed == null) || (compressed.length == 0)) {
            throw new IllegalArgumentException("Cannot unzip null or empty bytes");
        }
        if (!isZipped(compressed)) {
            return new String(compressed);
        }

        try (val byteArrayInputStream = new ByteArrayInputStream(compressed)) {
            try (val gzipInputStream = new GZIPInputStream(byteArrayInputStream)) {
                try (val inputStreamReader = new InputStreamReader(gzipInputStream, StandardCharsets.UTF_8)) {
                    try (val bufferedReader = new BufferedReader(inputStreamReader)) {
                        val output = new StringBuilder();
                        String line;
                        while((line = bufferedReader.readLine()) != null){
                            output.append(line);
                        }
                        return output.toString();
                    }
                }
            }
        }
        catch(final IOException e) {
            throw new GzipException("Failed to unzip content");
        }
    }

    private static boolean isZipped(final byte[] compressed) {
        return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
    }

}
