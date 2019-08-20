package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListApp {

    public static int total (LinkedList numbers) {

        int sum = 0;
        for (int i=0; i<numbers.size(); i++){
            sum = (int) numbers.get(i) + sum;
        }

        return sum;
    }

    public static int totalEven (LinkedList numbers) {

        int sum = 0;

        for(int i = 0; i<numbers.size(); i++){
            if(i%2==0){
                sum = sum + (int)numbers.get(i);
            }
        }

        return sum;
    }

    public static LinkedList swapFirstAndLast(LinkedList strings) {

        String firstPlace = (String) strings.get(0);
        String lastPlace = (String) strings.get(strings.size() - 1);

        strings.set(0, lastPlace);
        strings.set(strings.size()-1, firstPlace);

        return strings;
    }

    public static LinkedList reverse(LinkedList numbers) {

        Collections.reverse(numbers);

        return numbers;
    }

    public static LinkedList lessThanFive(LinkedList numbers) {

        int min = (int) Collections.min(numbers);

        if(min>4){
            return null;
        }else {
            for (int i = 0; i < numbers.size(); i++) {
                int num = (int) numbers.get(i);
                if (num > 4) {
                    numbers.remove(i);
                    i--;
                }
            }

        }
        return numbers;
    }
    //challenge
    public static ArrayList<ArrayList<Integer>> splitAtFive(LinkedList numbers) {

        ArrayList<Integer> lessThanFive = new ArrayList<>();
        ArrayList<Integer> moreThanFive = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int num = (int) numbers.get(i);
            if (num > 4) {
                moreThanFive.add((Integer) numbers.get(i));

            }
            if (num<=4){
                lessThanFive.add((Integer) numbers.get(i));
            }
        }

        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();

        arrays.add(lessThanFive);
        arrays.add(moreThanFive);

        return arrays;
    }

    // Challenge
    public static ArrayList<ArrayList<String>> evensAndOdds( LinkedList strings) {

        ArrayList<String> even = new ArrayList<>();
        ArrayList<String> odd = new ArrayList<>();

        for(int i = 0; i < strings.size(); i++) {
            if( i % 2 == 0 ) {
                even.add((String) strings.get(i));
            } else {
                odd.add((String) strings.get(i));
            }
        }

        ArrayList<ArrayList<String>> arrays = new ArrayList<>();

        arrays.add(even);
        arrays.add(odd);

        return arrays;
    }
}
