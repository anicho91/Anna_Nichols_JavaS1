import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndividualDigits {


    public static void main(String[] args) {

        int firstNum = 0;
        int secondNum = 0;
        int total = 0;

        for (int i = 10; i < 100; i++) {

            secondNum=i%10;
            firstNum=i/10;

                for(int j = 0; j<i; j++){
                    total = firstNum + secondNum;
                }

            System.out.println(i + ", " + firstNum + "+" + secondNum + " = " + " " + total);
        }
        
    }
}
