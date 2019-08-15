import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        Random ranGen = new Random();
        Scanner scan = new Scanner(System.in);

        int ranNum = ranGen.nextInt(3) + 1;

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards.\n");

        System.out.println("Which one is the ace?\n");

        System.out.println("\t##  ##  ##\n" +
                "\t##  ##  ##\n" +
                "\t1   2   3");

        int userNum = scan.nextInt();

        if (ranNum==1){
            if(userNum==ranNum){
                System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n" +
                        "\n" +
                        "\tAA  ##  ##\n" +
                        "\tAA  ##  ##\n" +
                        "\t1   2   3");
            }else{
                System.out.println("Ha! Fast Eddie wins again! The ace was card number 1.\n" +
                        "\n" +
                        "\tAA  ##  ##\n" +
                        "\tAA  ##  ##\n" +
                        "\t1   2   3");
            }
        }else if(ranNum==2){
            if(userNum==ranNum){
                System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n" +
                        "\n" +
                        "\t##  AA  ##\n" +
                        "\t##  AA  ##\n" +
                        "\t1   2   3");
            }else{
                System.out.println("Ha! Fast Eddie wins again! The ace was card number 2.\n" +
                        "\n" +
                        "\t##  AA  ##\n" +
                        "\t##  AA  ##\n" +
                        "\t1   2   3");
            }

        }else if(ranNum==3){
            if(userNum==ranNum){
                System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n" +
                        "\n" +
                        "\t##  ##  AA\n" +
                        "\t##  ##  AA\n" +
                        "\t1   2   3");
            }else{
                System.out.println("Ha! Fast Eddie wins again! The ace was card number 3.\n" +
                        "\n" +
                        "\t##  ##  AA\n" +
                        "\t##  ##  AA\n" +
                        "\t1   2   3");
            }
        }
    }
}
