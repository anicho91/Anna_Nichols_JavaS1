package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static int total(int[] myArray){

        //set sum at 0
        //each number in the array is added to the sum and it moves through the array
        int sum = 0;
        for (int i=0; i<myArray.length; i++){
            sum += myArray[i];
        }

        System.out.println(sum);
        return sum;
    }

    public static int totalOdd (int[] myArray){
        int sum = 0;

        //similar to first total except an if statement checking to make sure the number does not have a remainder of 0
        //when divided by 2 then adds the numbers that do have a remainder
        for (int i=0; i<myArray.length; i++){
            if (i%2 != 0){
                sum += myArray[i];
            }
        }

        System.out.println(sum);
        return (sum);
    }

    public static int totalEven (int[] myArray){
        int sum = 0;

        //Opposite if statement to totalOdd
        for (int i=0; i<myArray.length; i++){
            if (i%2 == 0){
                sum += myArray[i];
            }
        }

        System.out.println(sum);
        return (sum);
    }

    public static int secondLargestNumber(int[] myArray){

        //checks to make sure the array length is greater than 2
        if (myArray.length<2){
            return 0;
        }

        //grabs the first and second numbers in the array
        int arr1 = myArray[0];
        int arr2 = myArray[1];

        //initializes largest and secondLargest
        int largest = myArray[0];
        int secondLargest = myArray[0];

        //compares the first and second numbers so largest & secondLargest contain starting numbers
        // from the array instead of zero
        if (arr1>arr2){
            largest = arr1;
            secondLargest = arr2;
        } else {
            largest = arr2;
            secondLargest = arr1;
        }

        /* loops through the array and checks each number against the largest
            and if i is bigger than what's currently stored in largest, Largest becomes secondLargest
            then largest is replaced with new number
            If i is not bigger than largest then it is checked if it is bigger than secondLargest while still being less
            than largest. If it is then that number becomes the new secondLargest */

            for(int i=1; i<myArray.length; i++){
               if(myArray[i]>largest){
                   secondLargest=largest;
                   largest=myArray[i];
               }else if (myArray[i]>secondLargest && myArray[i]<largest){
                   secondLargest=myArray[i];
               }
            }

        System.out.println(secondLargest);
        return secondLargest;
    }

    public static String[] swapFirstAndLast (String[] myArray){
        //first capture length of array
        int arrLength = myArray.length;

        //capture the string in first place & last place
        // (arrLength=one more that the last index number so minus one to capture the last index number)
        String firstPlace=myArray[0];
        String lastPlace=myArray[arrLength-1];

        //swap the values at i0 and i'end of array'
        myArray[0]=lastPlace;
        myArray[arrLength-1]=firstPlace;

        return myArray;
    }

    public static int[] reverse(int[] myArray){
        int arrLength = myArray.length;

        //create new array to hold reversed array set to take the length of whatever the original array is
        int[] newArr = new int[arrLength];

        //loop through array and then add the numbers from myArray at i to newArr for the length of array -1
        // in descending order using -i
        //so starts by putting the first number at index 7 instead of index 0 and descends through the array length
        for(int i=0; i<myArray.length; i++){
            newArr[myArray.length -1 - i] = myArray[i];
        }

        return newArr;
    }

    public static String concatenateString(String[] myArray){
        //.join joins information in an array and turns it into a String
        // first declare how you want to divide the information (no space, space, comma, ect.)
        // then the array name you want to join together
        String concat = String.join("", myArray);
        return concat;
    }

    public static int[] everyThird(int[] myArray){
        //checks if myArray has at least 3 numbers
        //returns null otherwise
        if (myArray.length < 3){
            return null;
        } else {

            //capture array length
            int arrLength = myArray.length;

            //divide array length by 3 to get the array length  for the new array
            int arrL2= arrLength/3;

            //initialize new array with new length
            int[] newArr = new int[arrL2];

            //loop through myArray starting at the 2nd index (3rd number) and increment by 3
            for (int i = 2; i < myArray.length; i+=3) {

                //divide i by 3 to get the correct index for i in the newArray
                newArr[i/3] = myArray[i];
            }

            System.out.println(Arrays.toString(newArr));
            return newArr;
        }
    }

    public static int[] lessThanFive(int[] myArray){
        int arrLength = myArray.length;

        int number = 0;
        for(int j=0; j<myArray.length; j++){
            if (myArray[j]<5){
                number++;
            }
        }

        if (number<=0){
            return null;
        }else {

            int[] newArr = new int[number];

            for (int i = 0; i < myArray.length; i++) {
                if (i < 5) {
                    newArr[i] = myArray[i];
                }
            }

            System.out.println(Arrays.toString(newArr));
            return newArr;
        }
    }

}
