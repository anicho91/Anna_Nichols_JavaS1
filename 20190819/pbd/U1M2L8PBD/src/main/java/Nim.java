import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        String player1;
        String player2;
        int player1Count = 0;
        int player2Count = 1;

        Scanner scan = new Scanner(System.in);

        int pile1 = 3;
        int pile2 = 4;
        int pile3 = 5;

        System.out.println("Player 1, enter your name:");
        player1 = scan.nextLine();

        System.out.println("Player 2, enter your name:");
        player2 = scan.nextLine();

        do {
            System.out.println("A: " + pile1 + "\tB: " + pile2 + "\tC: " + pile3);

            String userInput = "a";
            String userInput2;
            int userNum = 0;

            if (player1Count == 0) {
                System.out.println(player1 + ", choose a pile:");

                userInput = scan.nextLine();

                if (userInput.equals("A") && pile1 == 0 || userInput.equals("a") && pile1 == 0
                        || userInput.equals("B") && pile2 == 0 || userInput.equals("b") && pile2 == 0
                        || userInput.equals("C") && pile3 == 0 || userInput.equals("c") && pile3 == 0) {
                    System.out.println("Nice try, " + player1 + ". That pile is empty. Choose again:");

                    userInput = scan.nextLine();

                }

                    System.out.println("How many to remove from pile " + userInput + ":");

                    userInput2 = scan.nextLine();
                    userNum = Integer.parseInt(userInput2);

                    if (userInput.equals("A") && userNum > pile1 || userInput.equals("a") && userNum > pile1 ||
                            userInput.equals("B") && userNum > pile2 || userInput.equals("b") && userNum > pile2 ||
                            userInput.equals("C") && userNum > pile3 || userInput.equals("c") && userNum > pile3) {
                        System.out.println("Pile " + userInput + " doesn't have that many. Try again:");
                        userInput2 = scan.nextLine();
                        userNum = Integer.parseInt(userInput2);
                    } else {
                        player1Count = 1;
                        player2Count = 0;
                    }

            } else if (player2Count == 0) {
                System.out.println(player2 + ", choose a pile:");

                userInput = scan.nextLine();

                if (userInput.equals("A") && pile1 == 0 || userInput.equals("a") && pile1 == 0
                        || userInput.equals("B") && pile2 == 0 || userInput.equals("b") && pile2 == 0
                        || userInput.equals("C") && pile3 == 0 || userInput.equals("c") && pile3 == 0) {
                    System.out.println("Nice try, " + player2 + ". That pile is empty. Choose again:");

                    userInput = scan.nextLine();

                }

                    System.out.println("How many to remove from pile " + userInput + ":");

                    userInput2 = scan.nextLine();
                    userNum = Integer.parseInt(userInput2);

                    if (userInput.equals("A") && userNum > pile1 || userInput.equals("a") && userNum > pile1 ||
                            userInput.equals("B") && userNum > pile2 || userInput.equals("b") && userNum > pile2 ||
                            userInput.equals("C") && userNum > pile3 || userInput.equals("c") && userNum > pile3) {
                        System.out.println("Pile " + userInput + " doesn't have that many. Try again:");
                        userInput2 = scan.nextLine();
                        userNum = Integer.parseInt(userInput2);
                    } else {
                        player1Count = 0;
                        player2Count = 1;
                    }

            }

                if (userInput.equals("A") && pile1 > 0 || userInput.equals("a") && pile1 > 0) {

                    pile1 = pile1 - userNum;

                } else if (userInput.equals("B") || userInput.equals("b")) {

                    pile2 = pile2 - userNum;

                } else if (userInput.equals("C") || userInput.equals("c")) {

                    pile3 = pile3 - userNum;

                }

                if (pile1 == 1 && pile2== 0 && pile3 == 0 ||
                    pile2 == 1 && pile1== 0 && pile3 == 0 ||
                    pile3==1 && pile2== 0 && pile1 == 0){

                    if(player1Count==0){
                        System.out.println(player1 + " you must take the last remaining counter, so\n" +
                                "you lose.");
                        break;
                    }else if(player2Count==0){
                        System.out.println(player2 + " you must take the last remaining counter, so\n" +
                                "you lose.");
                        break;
                    }

                }

            }while (pile1 > 0 || pile2 > 0 || pile3 > 0);

        if(player1Count==1){
            System.out.println(player2 + " wins!");

        }else if(player2Count==1){
            System.out.println(player1 + " wins!");

        }

    }
}
