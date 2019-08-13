public class SomeMath {
    public static void main(String[] args) {

        System.out.println(total5(1,2,3,4,5));

        System.out.println(average5(1, 3, 5, 7, 9));

        System.out.println(largest5(42.0, 35.1, 2.3, 40.2, 15.6));

    }

    public static int total5(int num1, int num2, int num3, int num4, int num5){
        int sum = num1 + num2 + num3 + num4 + num5;

        return sum;
    }

    public static int average5(int num1, int num2, int num3, int num4, int num5){

        int sum = num1 + num2 + num3 + num4 + num5;
        int average = sum/5;
        return average;
    }
//
    public static double largest5(double num1, double num2, double num3, double num4, double num5){
        double largest = 0;

        if (num1>largest){
            largest=num1;
        }
        if (num2>largest){
            largest=num2;
        }
        if (num3>largest){
            largest=num3;
        }
        if (num4>largest){
            largest=num4;
        }
        if (num5>largest){
            largest=num5;
        }

        return largest;
    }
}
