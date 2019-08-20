import java.util.Arrays;

public class ArrayFunReverseIt {
    public static void main(String[] args) {
        int[] myArray = new int[5];

        //i+1 to get it to start from 1
        for (int i=0; i<myArray.length; i++){
            myArray[i] = i+1;
        }

        int[] newArray = new int[5];

        //-i-1 tells it to start from the last index and move backwards through the array
        for (int i=0; i<myArray.length; i++){
            newArray[newArray.length-i-1]=myArray[i];
        }

        System.out.println(Arrays.toString(myArray));
        System.out.println(Arrays.toString(newArray));
    }
}
