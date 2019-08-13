import java.util.Arrays;
import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] myArray = new String[5];

        for (int i=0; i<myArray.length; i++){
            System.out.println("Please Enter a Word");
            String userInput1 = scan.nextLine();
            myArray[i]=userInput1;
        }

        System.out.println(Arrays.toString(myArray));
    }
}
