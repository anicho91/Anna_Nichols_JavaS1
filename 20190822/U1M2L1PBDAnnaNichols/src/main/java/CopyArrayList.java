import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CopyArrayList {
    public static void main(String[] args) {

        Random ranGen = new Random();

        ArrayList<Integer> ranArray = new ArrayList<>();

        for(int i=0; i<10; i++) {
            int ran1 = ranGen.nextInt(99) + 1;
            ranArray.add(ran1);
        }

        ArrayList<Integer> ranArray2 = new ArrayList<>(ranArray);

        ranArray.set(ranArray.size()-1, -7);

        System.out.println("ArrayList: " + ranArray);
        System.out.println("ArrayList: " + ranArray2);
    }
}
