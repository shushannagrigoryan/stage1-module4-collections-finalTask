package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> list = new LinkedList<>();
        for(Map.Entry<String, Set<String>> e: projects.entrySet()){
            if(e.getValue().contains(developer)){
                list.add(e.getKey());
            }
        }
        list.sort(Comparator.comparingInt(String::length).reversed());

        int index1 = 0;
        int index2 = 0;
        while(index2  < list.size() ){
            int length = list.get(index1).length();
            while(index2 < list.size() && list.get(index2).length() == length){
                index2++;
            }
            list.subList(index1, index2-1).sort(Comparator.reverseOrder());
            index1 = index2;
        }



        return list;
    }
}
