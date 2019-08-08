package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("What is your age");

        String userInput = scan.nextLine();

        int userNum = Integer.parseInt(userInput);

        if (userNum>=18){
            System.out.println("You can vote");
        }
        if (userNum >= 21) {
            System.out.println("You can drink alcohol");
        }
        if (userNum >= 35) {
            System.out.println("Be president");
        }
        if (userNum >= 55) {
            System.out.println("Is eligible for AARP");
        }
        if (userNum >= 65) {
            System.out.println("Can retire");
        }
        if (userNum >= 80 && userNum <= 89) {
            System.out.println("You're an octogenarian");
        }
        if (userNum >= 100) {
            System.out.println("You're more that a century old");
        }

    }
}
