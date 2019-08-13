import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number between 1 & 10");
        int userInput = scan.nextInt();

        if (userInput<1 || userInput>10){
          do {
             System.out.println("You must enter a number between 1 and 10, please try again.");
             userInput = scan.nextInt();
         } while (userInput<1 || userInput>10);
        }
        System.out.println(userInput);
    }
}
