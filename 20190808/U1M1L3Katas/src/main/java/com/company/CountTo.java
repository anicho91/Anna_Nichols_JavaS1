package com.company;

import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number");
        String userInput = scan.nextLine();
        int userNum = Integer.parseInt(userInput);

        for (int i=0; i<userNum+1; i++){
            System.out.println(i);
        }

    }
}
