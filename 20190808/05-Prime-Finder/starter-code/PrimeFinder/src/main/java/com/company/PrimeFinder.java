package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please input number");
        String userInput = scan.nextLine();
        int userNum = Integer.parseInt(userInput);

        for (int i=1; i<userNum; i++) {

            if (userNum%i != 0){
                System.out.println(i);
            }
        }
    }
}
