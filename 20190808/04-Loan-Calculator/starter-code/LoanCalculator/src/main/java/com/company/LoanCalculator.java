package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Enter amount of mortgage");
        String userMortgage = scan.nextLine();

        //Term of mortgage in months
        System.out.println("Enter term of mortgage");
        String userTerm = scan.nextLine();

        System.out.println("Enter Annual interest rate");
        String userAPR = scan.nextLine();

        double mortgage = Double.parseDouble(userMortgage);
        double term = Double.parseDouble(userTerm);
        double apr = Double.parseDouble(userAPR);

        double aprDec = apr/100;
        double monthlyInterestRate = aprDec/12;

        //Math.pow is a double so (double) before it to force it to be a double
        double exponent = Math.pow(1 + monthlyInterestRate, term);

        double monthlyExp = monthlyInterestRate * exponent;
        double dividend = mortgage * monthlyExp;

        double divisor = exponent - 1;

        double sumMonthlyPayment = dividend/divisor;

        System.out.println(sumMonthlyPayment);

    }
}

//aprDec = apr/100
//c = aprDec/12
//P = L[c(1 + c)n]/[(1 + c)n - 1]  calculate the fixed monthly payment
//P = mortgage[c(1 + c)^term]/[(1 + c)^term - 1]