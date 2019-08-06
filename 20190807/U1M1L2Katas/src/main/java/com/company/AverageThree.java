package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

//        BigDecimal y = new BigDecimal("1.00");
//        BigDecimal x = new BigDecimal("1.00");
//        BigDecimal z = new BigDecimal("1.00");
//        BigDecimal a = new BigDecimal("3.00");
//        BigDecimal b = (x.add(y));
//        BigDecimal c = (b.add(z));
//        BigDecimal d = (c.divide(a));
//        d = d.setScale(2, RoundingMode.FLOOR);
//        System.out.println(d);

        DecimalFormat dform = new DecimalFormat("#.00");
        System.out.println("Enter first number");
        float x = scan.nextFloat();
        System.out.println("Enter second number");
        float y = scan.nextFloat();
        System.out.println("Enter third number");
        float z = scan.nextFloat();

        float sum = (x + y + z)/3;

        System.out.println(dform.format(sum));


    }
}
