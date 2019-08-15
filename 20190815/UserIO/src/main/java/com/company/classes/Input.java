//package com.company.classes;
//
//import com.company.interfaces.UserIO;
//
//import java.util.Scanner;
//
//public class Input implements UserIO {
//    Scanner scan = new Scanner(System.in);
//
//    public int readInt(String prompt) {
//        System.out.println(prompt);
//        String userNum = scan.nextLine();
//        int userInt = Integer.parseInt(userNum);
//        return userInt;
//    }
//
//    public long readLong(String prompt) {
//        System.out.println(prompt);
//        String userNum = scan.nextLine();
//        long userLong = Long.parseLong(userNum);
//        return userLong;
//    }
//
//    public double readDouble(String prompt) {
//        System.out.println(prompt);
//        String userNum = scan.nextLine();
//        double userDouble = Double.parseDouble(userNum);
//        return userDouble;
//    }
//
//    public float readFloat(String prompt) {
//        System.out.println(prompt);
//        String userNum = scan.nextLine();
//        float userFloat = Float.parseFloat(userNum);
//        return userFloat;
//    }
//
//    public String readString(String prompt) {
//        System.out.println(prompt);
//        String userString = scan.nextLine();
//        return userString;
//    }
//}