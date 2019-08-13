import java.util.Random;

public class fortuneCookie {
    public static void main(String[] args){
        Random randomGen = new Random();

        int ranNum = randomGen.nextInt(6) + 1;
        int ranNum2 = randomGen.nextInt(89) + 10;
        int ranNum3 = randomGen.nextInt(89) + 10;
        int ranNum4 = randomGen.nextInt(89) + 10;
        int ranNum5 = randomGen.nextInt(89) + 10;
        int ranNum6 = randomGen.nextInt(89) + 10;
        int ranNum7 = randomGen.nextInt(89) + 10;

        String firstFortune = "Greens are recommended for dinner";
        String secondFortune = "Don't forget to shower";
        String thirdFortune = "Tomorrow will be great";
        String fourthFortune = "It'll rain tomorrow";
        String fifthFortune = "Expect a phone call";
        String sixthFortune = "Try again later";

        switch (ranNum){
            case 1:
                System.out.println(firstFortune + "\n" + ranNum2 + "-"
                        + ranNum3 + "-" + ranNum4 + "-" + ranNum5 + "-"
                        + ranNum6 + "-" + ranNum7);
                break;
            case 2:
                System.out.println(secondFortune + "\n" + ranNum2 + "-"
                        + ranNum3 + "-" + ranNum4 + "-" + ranNum5 + "-"
                        + ranNum6 + "-" + ranNum7);
                break;
            case 3:
                System.out.println(thirdFortune + "\n" + ranNum2 + "-"
                        + ranNum3 + "-" + ranNum4 + "-" + ranNum5 + "-"
                        + ranNum6 + "-" + ranNum7);
                break;
            case 4:
                System.out.println(fourthFortune + "\n" + ranNum2 + "-"
                        + ranNum3 + "-" + ranNum4 + "-" + ranNum5 + "-"
                        + ranNum6 + "-" + ranNum7);
                break;
            case 5:
                System.out.println(fifthFortune + "\n" + ranNum2 + "-"
                        + ranNum3 + "-" + ranNum4 + "-" + ranNum5 + "-"
                        + ranNum6 + "-" + ranNum7);
                break;
            case 6:
                System.out.println(sixthFortune + "\n" + ranNum2 + "-"
                        + ranNum3 + "-" + ranNum4 + "-" + ranNum5 + "-"
                        + ranNum6 + "-" + ranNum7);
                break;
        }
    }
}
