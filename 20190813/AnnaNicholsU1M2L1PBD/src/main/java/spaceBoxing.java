import java.util.Scanner;

public class spaceBoxing {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        double venus = 0.78;
        double mars = 0.39;
        double jupiter = 2.65;
        double saturn = 1.17;
        double uranus = 1.05;
        double neptune = 1.23;

        System.out.println("What is your weight on earth?");
        double userWeight = scan.nextDouble();

        System.out.println("I have information for the following planets: \n" +
                "1. Venus   2. Mars    3. Jupiter \n" +
                "4. Saturn  5. Uranus  6. Neptune");
        System.out.println("What planet are you visiting?");
        int userPlanet = scan.nextInt();

        double userPlanetNum = 0;

        switch (userPlanet){
            case 1:
                userPlanetNum = venus;
                break;
            case 2:
                userPlanetNum = mars;
                break;
            case 3:
                userPlanetNum = jupiter;
                break;
            case 4:
                userPlanetNum = saturn;
                break;
            case 5:
                userPlanetNum = uranus;
                break;
            case 6:
                userPlanetNum = neptune;
                break;
            default:
                System.out.println("Not Valid Number");
        }

        double sumWeight = userWeight * userPlanetNum;

        System.out.println("Your weight would be " + sumWeight + " pounds on that planet.");

    }
}
