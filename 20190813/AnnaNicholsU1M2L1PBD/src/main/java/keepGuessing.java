import java.util.Random;
import java.util.Scanner;

public class keepGuessing {
    public static void main(String[] args){
        Random ranGen = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");

        int ranNum = ranGen.nextInt(10)+1;

        int userInt = scan.nextInt();
        if (userInt == ranNum){
            System.out.println("That's right! You're a good guesser.");
        }else{
            while (userInt != ranNum){
                System.out.println("That is incorrect. Guess Again.");
                userInt = scan.nextInt();
            }
            System.out.println("That's right! You're a good guesser.");
        }





    }
}
