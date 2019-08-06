package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number");
        int num1 = Integer.parseInt(scan.nextLine());

        int sum = num1 + 13;

        System.out.println(sum);
    }
}
