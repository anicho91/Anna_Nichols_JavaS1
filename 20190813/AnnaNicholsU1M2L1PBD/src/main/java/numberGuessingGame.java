import java.util.Random;
import java.util.Scanner;

public class numberGuessingGame {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Random randomGen = new Random();

        System.out.println("I'm thinking of a number from 1 to 10 \nYour guess:");

        int userNum = scan.nextInt();

        int ranNum = randomGen.nextInt(10) + 1;
        if(userNum==ranNum){
            System.out.println("Yes, that's the right number!");
        }else {
            System.out.println("Sorry, but I was really thinking of " + ranNum);
        }
    }
}
