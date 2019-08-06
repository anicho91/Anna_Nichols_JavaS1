package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number 1");
            int num1 = Integer.parseInt(scan.nextLine());

        System.out.println("Enter number 2");
            int num2 = Integer.parseInt(scan.nextLine());

        System.out.println("Enter number 3");
            int num3 = Integer.parseInt(scan.nextLine());

        System.out.println("Enter number 4");
            int num4 = Integer.parseInt(scan.nextLine());

        System.out.println("Enter number 5");
            int num5 = Integer.parseInt(scan.nextLine());

           int sum = num1 + num2 + num3 + num4 + num5;

           System.out.println(sum);
    }
}
