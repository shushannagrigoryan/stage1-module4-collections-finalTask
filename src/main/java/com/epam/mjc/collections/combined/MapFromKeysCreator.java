package com.epam.mjc.collections.combined;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> map = new HashMap<>();
        for(Map.Entry<String, Integer> e: sourceMap.entrySet()){
            int len = e.getKey().length();
            String str = e.getKey();
            if(map.containsKey(len)){
                Set<String> set = map.get(len);
                set.add(str);
                map.put(len, set);
            }
            else{
                Set<String> set = new HashSet<>();
                set.add(str);
                map.put(len,set);
            }
        }
        return map;
    }
}
