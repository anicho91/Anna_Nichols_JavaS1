package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List> list = new ArrayList<>();
        List<Integer> inner1 = new ArrayList<Integer>();
        List<Integer> inner2 = new ArrayList<Integer>();
        List<Integer> inner3 = new ArrayList<Integer>();

        inner1.add(4);
        inner1.add(5);
        inner1.add(6);
        inner2.add(3);
        inner2.add(7);
        inner2.add(8);
        inner3.add(1);
        inner3.add(15);
        inner3.add(10);

        list.add(inner1);
        list.add(inner2);
        list.add(inner3);

        int average = 0;
        int total = 0;
        int count = 0;

        List<Integer> newList = new ArrayList<>();

        for(int i=0; i<list.size(); i++){

            for(int j=0; j<list.get(i).size(); j++){

                total = list.get(i).get(j).hashCode() + total;
                count++;

            }

            average = total/count;
            total = 0;

            newList.add(average);

        }

        System.out.println(newList);
    }
}
