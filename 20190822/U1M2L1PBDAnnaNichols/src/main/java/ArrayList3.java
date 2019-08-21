import java.util.ArrayList;
import java.util.Random;

public class ArrayList3 {

    public static void main(String[] args) {

        Random ranGen = new Random();

        ArrayList<Integer> ranArray = new ArrayList<>();

        for(int i=0; i<1000; i++) {
            int ran1 = ranGen.nextInt(89) + 10;
            ranArray.add(ran1);
        }

        System.out.println("ArrayList: " + ranArray);
    }

}
