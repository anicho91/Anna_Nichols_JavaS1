import java.util.Scanner;

public class aLittleQuiz {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int correctAnswers = 0;
        System.out.println("Are you ready for a quiz?");
        String userYN = scan.nextLine();
        System.out.println("Okay, here it comes!\n");

        System.out.println("Q1) What is the capital of Alaska?");
        int q1Ans1 = 1;
        int q1Ans2 = 2;
        int q1Ans3 = 3;
        System.out.println("\t1) Melbourne");
        System.out.println("\t2) Anchorage");
        System.out.println("\t3) Juneau");
        int userQ1 = scan.nextInt();
        if (userQ1 == q1Ans3){
            correctAnswers++;
            System.out.println("That's right!");
        }else{
            System.out.println("Incorrect. The correct answer is Juneau.");
        }

        System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?");
        int q2Ans1 = 1;
        int q2Ans2 = 2;
        System.out.println("\t1) yes");
        System.out.println("\t2) no");
        int userQ2 = scan.nextInt();
        if (userQ2 == q2Ans2){
            correctAnswers++;
            System.out.println("That's right!");
        }else{
            System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.");
        }

        System.out.println("Q3) What is the result of 9+6/3?");
        int q3Ans1 = 1;
        int q3Ans2 = 2;
        int q3Ans3 = 3;
        System.out.println("\t1) 5");
        System.out.println("\t2) 11");
        System.out.println("\t1) 15/3");
        int userQ3 = scan.nextInt();
        if (userQ3 == q3Ans2){
            correctAnswers++;
            System.out.println("That's right!");
        }else{
            System.out.println("That's incorrect. The answer is 11.");
        }

        System.out.println("Overall, you got "+correctAnswers+" out of 3 correct.");
        System.out.println("Thanks for playing!");

    }
}
