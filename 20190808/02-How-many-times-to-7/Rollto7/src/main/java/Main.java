import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        int randInt1 = 0;
        int randInt2 = 0;

        int diceSum = 0;

        int rollsTo7 = 0;
        int numOf7 = 0;
        int totalRolls = 0;

        for (int i = 1; i < 101; i++) {
            randInt1 = randomGenerator.nextInt(6) + 1;
            randInt2 = randomGenerator.nextInt(6) + 1;
            diceSum = randInt1 + randInt2;
            totalRolls++;

            System.out.println(diceSum);

            if (diceSum == 7) {
                numOf7++;
            }

            if (numOf7 == 1 && diceSum == 7) {
                rollsTo7 = totalRolls;
            }

        }

        System.out.println("It took " + rollsTo7 + " rolls to get a 7.");
        System.out.println("Seven was rolled " + numOf7 + "times.");
    }
}
