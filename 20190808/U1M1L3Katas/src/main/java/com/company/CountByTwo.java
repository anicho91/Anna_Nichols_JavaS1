package com.company;

import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number");
        String userInput = scan.nextLine();
        int userNum = Integer.parseInt(userInput);

        for (int i=0; i<userNum; i++){
            int num = i*2;
            if (num>userNum) {
                break;
            }else{
                System.out.println(i * 2);
            }
        }
    }
}
