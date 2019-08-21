package com.company;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadTVJson {

    public static void main(String[] args) {

        List<Television> tvList;

        try{
            ObjectMapper mapper = new ObjectMapper();

            tvList = mapper.readValue(new File("televisions.json"),
                    new TypeReference<List<Television>>(){});

            int screenSize = 60;

            List<Television> over60 =
                    tvList.stream().filter(tv->tv.getScreenSize()>screenSize).collect(Collectors.toList());

            over60.forEach(tv->{
                        System.out.println("Brand: " + tv.getBrand() + "\t Model: " + tv.getModel());
                    });

            System.out.println("\n");

            Map<String, List<Television>> groupBrands = tvList.stream().collect(Collectors.groupingBy(tv->tv.getBrand()));
            Set<String> keys = groupBrands.keySet();
            for(String key: keys){
                System.out.println(key);
            }

            System.out.println("\n");

            double avgScreenSize =
                    tvList.stream().mapToInt(tv->tv.getScreenSize()).average().getAsDouble();

            System.out.println("Average Screen Size: " + avgScreenSize);

            int maxScreenSize =
                    tvList.stream().mapToInt(tv->tv.getScreenSize()).max().getAsInt();

            System.out.println("Biggest Screen Size: " + maxScreenSize);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
