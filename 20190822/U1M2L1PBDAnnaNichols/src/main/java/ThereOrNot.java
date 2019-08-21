import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ThereOrNot {
    public static void main(String[] args) {
        Random ranGen = new Random();
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> ranArray = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int ran1 = ranGen.nextInt(49) + 1;
            ranArray.add(ran1);
        }

        System.out.println("ArrayList: " + ranArray);

        System.out.println("Value to find:");
        int userInput = scan.nextInt();

        boolean userReturn = ranArray.contains(userInput);

        if (userReturn == true) {
            System.out.println(userInput + " is in the ArrayList");
        } else {
            System.out.println(userInput + " is not in the ArrayList");
        }
    }
}
