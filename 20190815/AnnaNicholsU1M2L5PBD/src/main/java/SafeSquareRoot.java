import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("SQUARE ROOT!");
        System.out.println("Enter a number:");
        double userInt = scan.nextDouble();

        while(userInt<0){
            System.out.println("You can't take the square root of a negative number, silly");
            System.out.println("Try again:");
            userInt = scan.nextDouble();
        }

        if(userInt>0) {
            double sum = Math.sqrt(userInt);
            System.out.println("The square root of " + userInt + " is " + sum);
        }
    }
}
