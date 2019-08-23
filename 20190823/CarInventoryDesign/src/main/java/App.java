import java.util.*;
import java.util.stream.Collectors;

public class App {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Car newCar = new Car();

        String userInput;
        int userInt;
do {
    System.out.println("What would you like to do?");
    System.out.println("1. Add a car \t 2. Remove a car \n3. See all cars available \t 4. Search for a car  \nHit 0 to exit");
    userInput = scan.nextLine();
    userInt = Integer.parseInt(userInput);

    if (userInt == 1) {
        String make2;
        String model2;
        int year2;
        String color2;
        int miles2;

        System.out.println("Input information you want to add");

        System.out.println("Input Make");
        make2 = scan.nextLine();

        System.out.println("Input Model");
        model2 = scan.nextLine();

        System.out.println("Input Year");
        String userI2 = scan.nextLine();
        year2 = Integer.parseInt(userI2);

        System.out.println("Input Color");
        color2 = scan.nextLine();

        System.out.println("Input Miles");
        userI2 = scan.nextLine();
        miles2 = Integer.parseInt(userI2);

        System.out.println("You input: " + make2 + " " + model2 + " " + year2 +
                " " + color2 + " " + miles2);

        newCar.add(new Car(make2, model2, year2, color2, miles2));

    } else if (userInt == 2) {

        String make2;
        String model2;
        int year2;
        String color2;
        int miles2;

        System.out.println("Input the model you want to remove");


        System.out.println("Input Model");
        model2 = scan.nextLine();

        Map<String, List<Car>> carMap = new HashMap<>();
        Set<Map.Entry<String, List<Car>>> myEntries = carMap.entrySet();
        for (Map.Entry<String, List<Car>> entry : myEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        carMap.remove(model2);

    } else if (userInt == 3) {
        Map<String, List<Car>> carMap =
                newCar.getAll().stream()
                        .collect(Collectors.groupingBy(c->c.getModel()));

        Set<String> keys = carMap.keySet();
        for(String key : keys) {
            System.out.println(key);
        }
    } else if (userInt == 4) {

    } else if(userInt == 0) {
        System.out.println("Goodbye");
    }else{
        System.out.println("Invalid Selection");
    }
        }while(userInt!=0);
    }
}
