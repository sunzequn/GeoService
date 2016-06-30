package cn.edu.nju.ws.geokb.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Sloriac on 16/2/14.
 */
public class GeoNameUtil {

    private static final String URI_PREFIX = "http://sws.geonames.org/";

    public static String getUri(int id) {
        return URI_PREFIX + id + "/";
    }

    public static int parseId(String uri) {
        uri = StringUtils.removeStart(uri, URI_PREFIX);
        uri = StringUtils.removeEnd(uri, "/");
        return Integer.parseInt(uri);
    }
}
