package com.company;

import java.util.*;


public class App {

    public String printKeys(Map<String, String> newMap){
        Set<String> myKeys = newMap.keySet();
        for (String key:myKeys){
            System.out.println(key);
        }
        return null;
    }

    public String printValues(Map<String, String> newMap){
        Collection<String> myValues = newMap.values();
        for (String values:myValues){
            System.out.println(values);
        }
        return null;
    }

    public String printKeysAndValues(Map<String, String> newMap){
        Set<Map.Entry<String, String>> myEntries = newMap.entrySet();
        for (Map.Entry<String, String> entry:myEntries){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        return null;
    }

    public Map<String, Integer> mapFun(Map<String, Integer> newMap){

        newMap.put("Smart Fortwo", 2013);
        newMap.put("Ford Explorer", 2012);

        newMap.remove("Jeep Wrangler");

        return newMap;
    }

    public Map<String, List<Car>> listCars(Map<String, List<Car>> newMap){

        Map<String, List<Car>> carList = new HashMap<>();

      Set<Map.Entry<String, List<Car>>> myEntries = carList.entrySet();
      for(Map.Entry<String, List<Car>> entry:myEntries){

      }

        return newMap;
    }
}
