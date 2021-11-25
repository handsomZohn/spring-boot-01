package workspace.countersign;

import java.security.PrivateKey;
import java.util.*;

public class Countersign01 {
    public static PrivateKey getPrivateKeyFromString(String base64String) {
        Base64.getEncoder();
        return null;
    }

    public static String createLinkString(Map<String, String> params) {
        ArrayList<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        StringBuffer linkStr = new StringBuffer();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (value == null) {
                continue;
            }
            if (i == keys.size() - 1) {
                linkStr.append(key).append("=").append(value);
            } else {
                linkStr.append(key).append("=").append(value).append("&");
            }
        }
        return linkStr.toString();
    }
}