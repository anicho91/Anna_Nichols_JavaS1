import java.util.Random;

public class BabyBlackjack {
    public static void main(String[] args) {
        Random ranGen = new Random();

        int userNum1 = ranGen.nextInt(11) + 1;
        int userNum2 = ranGen.nextInt(11) + 1;

        int dealerNum1 = ranGen.nextInt(11) + 1;
        int dealerNum2 = ranGen.nextInt(11) + 1;

        int userSum = userNum1 + userNum2;
        int dealerSum = dealerNum1 + dealerNum2;

        System.out.println("Baby Blackjack!\n");

        System.out.println("You drew " + userNum1 + " " + userNum2 + ".");
        System.out.println("Your total is " + userSum);

        System.out.println("\nDealer drew " + dealerNum1 + " " + dealerNum2 + ".");
        System.out.println("Dealer's total is " + dealerSum);

        if(userSum>dealerSum){
            System.out.println("\nYOU WIN!");
        }else{
            System.out.println("\nYOU LOSE!");
        }
    }
}
