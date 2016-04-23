package com.pavelrudenok.is.util;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static String hashMapToString(HashMap<Integer, Integer> hashMap) {
        StringBuilder sb = new StringBuilder();
        String prefix = "";

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            sb.append(prefix);
            prefix = ",";
            sb.append(entry.getKey() + "=" + entry.getValue());
        }

        return sb.toString();
    }


    public static HashMap<Integer, Integer> stringToHashMap(String string) {
        String[] arr = string.split(",");
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (String str : arr) {
            String[] s = str.split("=");

            hashMap.put(Integer.valueOf(s[0]), Integer.valueOf(s[1]));
        }

        return hashMap;
    }
}
