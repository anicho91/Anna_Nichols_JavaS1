import java.util.Scanner;

public class AddingValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("I will add up the numbers you give me\n" +
                "Number:");
        String userInput = scan.nextLine();
        int userNum = Integer.parseInt(userInput);
        int sum=userNum;
        System.out.println("The total so far is " + userNum);

        while (userNum != 0) {
            System.out.println("Number: ");
            userInput = scan.nextLine();
            userNum = Integer.parseInt(userInput);

            sum = userNum+sum;
            if(userNum!=0) {
                System.out.println("The total so far is " + sum);
            }
        }

        System.out.println("The total is " + sum);

    }
}
