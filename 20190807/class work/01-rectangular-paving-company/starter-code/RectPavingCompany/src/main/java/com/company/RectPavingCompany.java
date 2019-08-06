package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give Integer in feet for width of the driveway in whole numbers");
        int num1 = Integer.parseInt(scan.nextLine());

        System.out.println("Give Integer in feet for length of the driveway in whole numbers");
        int num2 = Integer.parseInt(scan.nextLine());

        int area = num1 * num2;
        System.out.println(area);
        int perim = 2 * (num1 + num2);
        System.out.println(perim);

//        With set cost
//        float cemCost = area * 12.50f;

        //BigDecimal allows you to use .setScale and create a scale to show zeros past the decimal point so 17.00 is shown as 17.00 instead of 17.0
        BigDecimal area2 = new BigDecimal(area);
        BigDecimal cemCost = new BigDecimal("12.50");
        BigDecimal cCost = area2.multiply(cemCost);
        cCost = cCost.setScale(2, RoundingMode.FLOOR);
        System.out.println(cCost);

//        float perimCost = perim * 8.25f;
        BigDecimal perim2 = new BigDecimal(perim);
        BigDecimal perimCost = new BigDecimal("8.25");
        BigDecimal pCost = perim2.multiply(perimCost);
        pCost = pCost.setScale(2, RoundingMode.FLOOR);
        System.out.println(pCost);

//        With user input
        System.out.println("Give cost per square feet");
        float cemCap = scan.nextFloat();
        System.out.println("Give cost for framing");
        float perimCap = scan.nextFloat();

        float cemCost2 = area * cemCap;
        System.out.println(cemCost2);
        float perimCost2 = perim * perimCap;
        System.out.println(perimCost2);
    }
}
