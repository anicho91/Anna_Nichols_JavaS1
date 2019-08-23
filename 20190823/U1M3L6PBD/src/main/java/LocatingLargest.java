import java.util.ArrayList;
import java.util.Random;

public class LocatingLargest {

    public static void main(String[] args) {
        Random ranGen = new Random();

        ArrayList<Integer> ranArray = new ArrayList<>();

        for(int i=0; i<10; i++) {
            int ran1 = ranGen.nextInt(99) + 1;
            ranArray.add(ran1);
        }

        System.out.println("ArrayList: " + ranArray);

        int largest = ranArray.get(0);
        int slot = 0;

        for (int i=0; i<ranArray.size(); i++){
            if(ranArray.get(i) >largest){
                largest= ranArray.get(i);
                slot = i;
            }
        }

        System.out.println("The largest value is " + largest + ", which is in slot " + slot);

    }
}
