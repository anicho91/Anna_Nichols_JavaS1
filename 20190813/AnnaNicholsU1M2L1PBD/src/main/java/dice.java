import java.util.Random;

public class dice {
    public static void main(String[] args){
        Random randomGen = new Random();

        System.out.println("HERE COMES THE DICE!");

        int ranNum1 = randomGen.nextInt(6)+1;
        int ranNum2 = randomGen.nextInt(6)+1;

        System.out.println("Roll #1: " + ranNum1);
        System.out.println("Roll #2: " + ranNum2);

        int sum = ranNum1 + ranNum2;

        System.out.println("The total is " + sum + "!");
    }
}
