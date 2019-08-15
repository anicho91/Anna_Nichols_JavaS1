import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter three integers");

        System.out.println("Side 1:");
        int side1 = scan.nextInt();
        System.out.println("Side 2:");
        int side2 = scan.nextInt();
        if(side1>side2){
            System.out.println(side2 + " is smaller than " + side1 + ". Try again.");
            side2=scan.nextInt();
        }
        System.out.println("Side 3");
        int side3 = scan.nextInt();
        if(side2>side3){
            System.out.println(side3 + " is smaller than " + side2 + ". Try again.");
            side3=scan.nextInt();
        }

        System.out.println("Your three sides are " + side1 +" " + side2 + " " + side3);
        int a = side1*side1;
        int b = side2*side2;
        int plus = a + b;
        double sqrt = Math.sqrt(plus);
        if (sqrt==side3){
            System.out.println("These sides *do* make a right triangle. Yippy-skippy!");
        }else{
            System.out.println("NO! These sides do not make a right triangle!");
        }
    }
}
