package dev.masterflomaster1.jwa.internal;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UrlComparator {

    private UrlComparator() { }

    public static boolean compareUrls(String url1, String url2) {
        try {
            URI uri1 = new URI(url1);
            URI uri2 = new URI(url2);

            if (!uri1.getScheme().equals(uri2.getScheme()) ||
                    !uri1.getHost().equals(uri2.getHost()) ||
                    !uri1.getPath().equals(uri2.getPath())) {
                return false;
            }

            Map<String, List<String>> params1 = getQueryParams(uri1);
            Map<String, List<String>> params2 = getQueryParams(uri2);

            return params1.equals(params2);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static Map<String, List<String>> getQueryParams(URI uri) {
        Map<String, List<String>> params = new HashMap<>();
        String query = uri.getQuery();
        if (query == null) {
            return params;
        }

        String[] pairs = query.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            String key = keyValue[0];
            String value = keyValue.length > 1 ? keyValue[1] : "";

            List<String> valuesList = Arrays.asList(value.split("\\|"));
            Collections.sort(valuesList);

            params.put(key, valuesList);
        }

        return params;
    }


}
