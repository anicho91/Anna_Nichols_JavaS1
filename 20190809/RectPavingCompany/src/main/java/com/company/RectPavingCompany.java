package com.company;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //added \n to all questions(ln11, ln14, ln20, & ln24) so the input went to the next line instead of the end of the question
        System.out.print("What is the width of the driveway in feet? \n");
        int width = Integer.parseInt(scan.nextLine());

        System.out.print("What is the length of the driveway in feet? \n");
        int length = Integer.parseInt(scan.nextLine());

        float cementCost = 0.0f;
        float framingCost = 0.0f;

        System.out.print("What is the cost of cement per square foot? \n");
        cementCost = Float.parseFloat(scan.nextLine());

        //Used cement cost variable instead of framing cost variable at ln25
        System.out.print("What is the cost of framing/footers per linear foot? \n");
        framingCost = Float.parseFloat(scan.nextLine());

        int area = length * width;

        //had 2*l - 2*w when the correct perimeter formula is 2*l + 2*w at ln29
        int perimeter = 2*length + 2*width;

        System.out.format("The area of the driveway is %d square feet.%n", area);
        System.out.format("The perimeter of the driveway is %d square feet.%n", perimeter);

        System.out.format("The cost of the cement is %f.%n", area*cementCost);

        //had perimeter+framingCost when it needs to be perimeter*framingCost to find the actual cost at ln 38
        System.out.format("The cost of the framing/footers is %f.%n", perimeter*framingCost);
    }
}
