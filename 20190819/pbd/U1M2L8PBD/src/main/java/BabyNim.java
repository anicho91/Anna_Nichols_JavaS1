import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pile1 = 3;
        int pile2 = 3;
        int pile3 = 3;

                do {
                    System.out.println("A: " + pile1 + "\tB: " + pile2 + "\tC: " + pile3);

                    System.out.println("Choose a pile:");

                    String userInput = scan.nextLine();

                    System.out.println("How many to remove from pile " + userInput + ":");

                    String userInput2 = scan.nextLine();
                    int userNum = Integer.parseInt(userInput2);

                    if (userInput.equals("A") || userInput.equals("a")) {

                        pile1 = pile1 - userNum;

                    } else if (userInput.equals("B") || userInput.equals("b")) {

                        pile2 = pile2 - userNum;

                    } else if (userInput.equals("C") || userInput.equals("c")) {

                        pile3 = pile3 - userNum;

                    }

                }while (pile1>0 || pile2>0 || pile3>0);

        System.out.println("All piles are empty. Good job!");

    }
}
