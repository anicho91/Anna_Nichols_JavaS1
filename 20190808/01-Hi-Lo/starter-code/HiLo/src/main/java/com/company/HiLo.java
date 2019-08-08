package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Hi-Low!");

        System.out.println("Input name");
        String userName = scan.nextLine();

        System.out.println("OK, " + userName + ", here are the rules:");

        Random randomGen = new Random();

        int randInt = randomGen.nextInt(100) + 1;

        String userInput;
        int userInt;
        int guessNum = 0;

        do{
            System.out.println("Guess a number");
            userInput = scan.nextLine();
            userInt = Integer.parseInt(userInput);

            guessNum++;

            if (userInt<randInt) {
                System.out.println("Too low!");
            } else if (userInt>randInt) {
                System.out.println("Too high!");
            }

        }while (userInt != randInt);

        System.out.println("Congratulations, " + userName + "! You win!");
        System.out.println("It took you " + guessNum + " guesses to find my number!");
    }
}
