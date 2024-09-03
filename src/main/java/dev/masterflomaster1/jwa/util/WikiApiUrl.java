package dev.masterflomaster1.jwa.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class WikiApiUrl {

    private String action;
    private final HashMap<String, String> map = new HashMap<>();
    private final HashMap<String, String> propMap = new HashMap<>();
    private final HashMap<String, String> listMap = new HashMap<>();
    private final HashMap<String, String> metaMap = new HashMap<>();

    public void setAction(String value) {
        action = value;
    }

    public void putQuery(String k, Object v) {
        map.put(k, v.toString());
    }

    public void putProp(String k, String v) {
        propMap.put(k, v);
    }

    public void putList(String k, String v) {
        listMap.put(k, v);
    }

    public void putMeta(String k, String v) {
        metaMap.put(k, v);
    }

    public void appendQuery(String k, String v) {
        v = URLEncoder.encode(v, StandardCharsets.UTF_8);

        if (map.containsKey(k))
            map.put(k, map.get(k) + "|" + v);
        else
            map.put(k, v);
    }

    public String build() {
        StringBuilder urlBuilder = new StringBuilder();

        if (action != null)
            urlBuilder.append("?action=").append(action);

        if (!propMap.isEmpty()) {
            urlBuilder
                    .append("&prop=")
                    .append(String.join("%7C", propMap.keySet()))
                    .append(String.join("", propMap.values()));
        }

        if (!listMap.isEmpty()) {
            urlBuilder
                    .append("&list=")
                    .append(String.join("%7C", listMap.keySet()))
                    .append(String.join("", listMap.values()));
        }

        if (!metaMap.isEmpty()) {
            urlBuilder
                    .append("&meta=")
                    .append(String.join("%7C", metaMap.keySet()))
                    .append(String.join("", metaMap.values()));
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            urlBuilder.append("&")
                    .append(entry.getKey())
                    .append("=")
                    .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }

        return urlBuilder.toString();
    }

}
