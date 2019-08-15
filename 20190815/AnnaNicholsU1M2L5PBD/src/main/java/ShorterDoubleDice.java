import java.util.Random;

public class ShorterDoubleDice {
    public static void main(String[] args) {
        Random randomGen = new Random();

        int ranNum1;
        int ranNum2;

        do {
            System.out.println("HERE COMES THE DICE!");

            ranNum1 = randomGen.nextInt(6) + 1;
            ranNum2 = randomGen.nextInt(6) + 1;

            System.out.println("Roll #1: " + ranNum1);
            System.out.println("Roll #2: " + ranNum2);

            int sum = ranNum1 + ranNum2;

            System.out.println("The total is " + sum + "!");
        }
        while (ranNum1 != ranNum2);

    }

}
