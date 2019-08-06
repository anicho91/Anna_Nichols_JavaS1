package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter first name");
        String firstName = scan.nextLine();

        System.out.println("Enter last name");
        String lastName = scan.nextLine();

        System.out.println("Enter Email");
        String email = scan.nextLine();

        System.out.println("Twitter Handle");
        String twitterHandle = scan.nextLine();

        System.out.println("Enter Age");
        int age = Integer.parseInt(scan.nextLine());

        System.out.println("Enter Country");
        String country = scan.nextLine();

        System.out.println("Enter Profession");
        String profession = scan.nextLine();

        System.out.println("Enter Favorite Operating System");
        String opSystem = scan.nextLine();

        System.out.println("Enter Favorite Programming Language");
        String progLanguage = scan.nextLine();

        System.out.println("Enter Favorite Computer Scientist");
        String compScientist = scan.nextLine();

        System.out.println("Enter Favorite Keyboard Shortcut");
        String keyShort = scan.nextLine();

        System.out.println("Have you ever built your own computer (y/n)");
        String ownComp = scan.nextLine();

        System.out.println("If you could be any superhero, who would it be");
        String superhero = scan.nextLine();

        //  "\n" creates a line break when displaying information
        System.out.println(firstName + "\n" + lastName + "\n" + email + "\n"
                + twitterHandle + "\n" + age + "\n" + country + "\n" + profession
                + "\n" + opSystem + "\n" + progLanguage + "\n" + compScientist + "\n" +
                keyShort + "\n" + ownComp + "\n" + superhero);

    }
}
