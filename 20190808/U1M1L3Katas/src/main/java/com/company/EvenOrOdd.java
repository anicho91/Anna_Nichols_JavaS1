package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Input a whole number");
        String userInput = scan.nextLine();
        int userInt = Integer.parseInt(userInput);
        int sum = userInt%2;

        if (sum == 0){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
