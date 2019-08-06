package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Salary of Player 1 (only numbers)");
            int player1 = Integer.parseInt(scan.nextLine());
        System.out.println("Enter Salary of Player 2 (only numbers)");
            int player2 = Integer.parseInt(scan.nextLine());
        System.out.println("Enter Salary of Player 3 (only numbers)");
            int player3 = Integer.parseInt(scan.nextLine());

            int sum = player1 + player2 + player3;

            System.out.println(sum);

            if (sum > 40000000) {
                float taxRate = 0.18f;
                float sumOver = sum - 40000000;
                float taxTotal = sumOver * taxRate;
                System.out.println("Cost of Luxury Tax " + taxTotal);
            }
    }
}
