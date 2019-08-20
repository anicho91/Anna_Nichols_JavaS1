package com.company;

import java.util.*;

public class App {

    public static int total (ArrayList<Integer> numbers) {

        int sum = 0;
//        for(int num : numbers) {
//            sum += num;
//        }

        Iterator<Integer> iter = numbers.iterator();

        while (iter.hasNext()){
            sum = sum + iter.next();
        }

        return sum;
    }

    public static int totalEven (ArrayList<Integer> numbers) {

        int sum = 0;

        for(int i = 0; i<numbers.size(); i++){
            if(i%2==0){
                sum = sum + numbers.get(i);
            }
        }

        return sum;
    }

    public static ArrayList<String> swapFirstAndLast(ArrayList<String> strings) {

        String firstPlace = strings.get(0);
        String lastPlace = strings.get(strings.size() - 1);

        strings.set(0, lastPlace);
        strings.set(strings.size()-1, firstPlace);

        return strings;
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> numbers) {

        Collections.reverse(numbers);

        return numbers;
    }

    public static ArrayList<Integer> lessThanFive(ArrayList<Integer> numbers) {

        int min = Collections.min(numbers);

        if(min>4){
            return null;
        }else {
            for (int i = 0; i < numbers.size(); i++) {
                int num = numbers.get(i);
                if (num > 4) {
                    numbers.remove(i);
                    i--;
                }
            }

        }
        return numbers;
    }

    //challenge
    public static ArrayList<ArrayList<Integer>> splitAtFive(ArrayList<Integer> numbers) {

        ArrayList<Integer> lessThanFive = new ArrayList<>();
        ArrayList<Integer> moreThanFive = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if (num > 4) {
                moreThanFive.add(numbers.get(i));

            }
            if (num<=4){
                lessThanFive.add(numbers.get(i));
            }
        }

        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();

        arrays.add(lessThanFive);
        arrays.add(moreThanFive);

        return arrays;
    }

    // Challenge
    public static ArrayList<ArrayList<String>> evensAndOdds( ArrayList<String> strings) {

        ArrayList<String> even = new ArrayList<>();
        ArrayList<String> odd = new ArrayList<>();

        for(int i = 0; i < strings.size(); i++) {
            if( i % 2 == 0 ) {
                even.add(strings.get(i));
            } else {
                odd.add(strings.get(i));
            }
        }

        ArrayList<ArrayList<String>> arrays = new ArrayList<>();

        arrays.add(even);
        arrays.add(odd);

        return arrays;
    }
}
