import java.util.Arrays;
import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] myArray = new int[5];

        for (int i=0; i<myArray.length; i++){
            System.out.println("Please Enter Number");
            int userInput1 = scan.nextInt();
            myArray[i]=userInput1;
        }

        System.out.println(Arrays.toString(myArray));
    }
}
