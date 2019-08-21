import java.util.ArrayList;
import java.util.Random;

public class ArrayList2 {

    public static void main(String[] args) {

        Random ranGen = new Random();

        ArrayList<Integer> ranArray = new ArrayList<>();

        for(int i=0; i<10; i++) {
            int ran1 = ranGen.nextInt(99) + 1;
            ranArray.add(ran1);
        }

        System.out.println("ArrayList: " + ranArray);
    }
}
