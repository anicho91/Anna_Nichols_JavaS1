package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String userInput;
        String answer = "Java";

        do {
            System.out.println("What is your favorite programming language?");
            userInput = scan.nextLine();



        } while (!answer.equals(userInput));

        System.out.println("That's what I was looking for! Java is definitely the answer!");
    }
}
