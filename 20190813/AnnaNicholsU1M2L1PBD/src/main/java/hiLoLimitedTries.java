import java.util.Random;
import java.util.Scanner;

public class hiLoLimitedTries {
    public static void main (String[] args){
        Random ranGen = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("I have chosen a number between 1 and 100. You have 7 guesses.");

        int ranNum = ranGen.nextInt(100)+1;
        int counter = 1;
        int userInt = scan.nextInt();
        if (userInt == ranNum){
            System.out.println("You guessed it! What are the odds?!?");
        }else{
            while (userInt != ranNum && counter<7){
                System.out.println("That is incorrect. Guess Again.");
                userInt = scan.nextInt();
                counter++;
            }
            if(userInt==ranNum) {
                System.out.println("That's right! You're a good guesser.");
            } else {
                System.out.println("Sorry, you didn't guess it in 7 tries. You lose.");
            }
        }
    }
}
