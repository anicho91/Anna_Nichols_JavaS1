package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userInput;
        int userNum;
        do {
            System.out.println("Enter a number between 1 & 100");
            userInput = scan.nextLine();
            userNum = Integer.parseInt(userInput);

        } while (userNum != 42);

        System.out.println("That's the number I was looking for! 42 is definitely the answer!");
    }
}
