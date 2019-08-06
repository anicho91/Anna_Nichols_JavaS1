package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        System.out.println("Enter number 1");
//        int num1 = Integer.parseInt(scan.nextLine());
//
//        System.out.println("Enter number 2");
//        int num2 = Integer.parseInt(scan.nextLine());
//
//        System.out.println("Enter number 3");
//        int num3 = Integer.parseInt(scan.nextLine());

        System.out.println("Enter first number");
        float x = scan.nextFloat();
        System.out.println("Enter second number");
        float y = scan.nextFloat();
        System.out.println("Enter third number");
        float z = scan.nextFloat();

        float sum = x * y *z;
        System.out.println(sum);
    }
}