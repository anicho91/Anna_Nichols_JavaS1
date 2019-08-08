package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your age");
        String userInput = scan.nextLine();
        int userInt = Integer.parseInt(userInput);

        if (userInt<14){
            System.out.println("What grade are you in?");
            String userGrade = scan.nextLine();

            System.out.println("Wow! " +userGrade+" grade - that sounds exciting!");
        }else if(userInt>=14 && userInt<=18){
            System.out.println("Do you plan on going to college");
            String userAns = scan.nextLine();
            if (userAns.equals("yes")){
                System.out.println("What college?");
                String userColl = scan.nextLine();
                System.out.println( userColl + " is a great school!");
            } else if (userAns.equals("no")){
                System.out.println("What do you plan to do after highschool?");
                String userOther = scan.nextLine();
                System.out.println("Wow, " +userOther+ " sounds like a plan!");
            }
        }else if(userInt>18) {
            System.out.println("What is your job?");
            String userJob = scan.nextLine();
            System.out.println(userJob + " sounds like a great job!");
        }
    }
}
