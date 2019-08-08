package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userInput;
        int userNum;
        do {
            System.out.println("\nEnter a number between 15 & 32");
            userInput = scan.nextLine();
            userNum = Integer.parseInt(userInput);

        } while (userNum < 15 || userNum > 32);

        System.out.println(userNum);
    }
}
