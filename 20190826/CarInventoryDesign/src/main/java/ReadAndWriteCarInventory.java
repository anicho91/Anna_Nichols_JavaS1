import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.util.*;

public class ReadAndWriteCarInventory {

    public static void main(String[] args) throws IOException {
        PrintWriter writer = null;
        ObjectMapper mapper = new ObjectMapper();
        CarInventory inventory = mapper.readValue(new File("cars.json"),
                CarInventory.class);


        int userInt=1;
        do {
            try{

            Scanner scan = new Scanner(System.in);


            System.out.println("What would you like to do?");
            System.out.println("1. Add a car \t 2. Remove a car \n3. See all cars available \t 4. Search for a car \nHit 0 to exit");
            String userInput = scan.nextLine();
            userInt = Integer.parseInt(userInput);

            if(userInt == 1){
                String make;
                String model;
                int year;
                String color;
                int miles;

                System.out.println("Input information you want to add");

                System.out.println("Input make");
                make = scan.nextLine();

                System.out.println("Input model");
                model = scan.nextLine();

                System.out.println("Input year");
                String userI2 = scan.nextLine();
                year = Integer.parseInt(userI2);

                System.out.println("Input color");
                color = scan.nextLine();

                System.out.println("Input miles");
                userI2 = scan.nextLine();
                miles = Integer.parseInt(userI2);

                Car car = new Car();
                car.setmake(make);
                car.setmodel(model);
                car.setcolor(color);
                car.setmiles(miles);
                car.setyear(year);

                inventory.addCar(car);

                String carList = mapper.writeValueAsString(inventory.getCarList());
                writer = new PrintWriter(new FileWriter("cars.json"));
                writer.println(carList);

            }else if(userInt == 2){

                String make2;
                String model2;
                int year2;
                String color2;
                int miles2;

                System.out.println("Input information you want to remove");

                System.out.println("Input make");
                make2 = scan.nextLine();

                System.out.println("Input model");
                model2 = scan.nextLine();

                System.out.println("Input color");
                color2 = scan.nextLine();

                System.out.println("You input: " + make2 + " " + model2 + " " +
                        " " + color2);

//                newCar.remove();

//                String fileLoc = "cars.json";
//
//                String jsonCarList = mapper.writeValueAsString(newCar);
//
//                writer = new PrintWriter(new FileWriter(fileLoc));
//
//                writer.println(jsonCarList);

            }else if(userInt == 3){

                for (Car car : inventory.getCarList()) {
                    System.out.println(car.getmake() + " " + car.getmodel() + " "
                            + car.getyear() + " " + car.getcolor() + " " + car.getmiles());
                }

            }else if(userInt == 4){

                System.out.println("Select which you'd like to search by \n1. Make \t 2. Model \n3. Mileage");

                    userInput = scan.nextLine();
                    userInt = Integer.parseInt(userInput);

                    if(userInt==1){

                        System.out.println("Enter the Make you'd like to find");
                        String userInput2 = scan.nextLine();

                        for (Car car : inventory.getCarList()) {
                            inventory.getCarList().contains(userInput2);
                            System.out.println(car.getmodel() + " " + car.getcolor() + "  " + car.getyear());
                        }

                    }else if(userInt==2){
                        System.out.println("Enter the Model you'd like to find");
                        String userInput2 = scan.nextLine();

                        for (Car car : inventory.getCarList()) {
                            inventory.getCarList().contains(userInput2);
                            System.out.println(car.getmake() + " " + car.getcolor() + "  " + car.getyear());
                        }
                    }else if(userInt==3){
                        
                    }

            }else if(userInt == 0) {
                System.out.println("Goodbye");
            }else {
                System.out.println("Invalid Selection");
            }

//            String jsonCarList = mapper.writeValueAsString(newCar);
//
//            System.out.println(jsonCarList);
//
//            writer = new PrintWriter(new FileWriter("cars.json", true));
//
//            writer.println(jsonCarList);

        }catch (FileNotFoundException | JsonProcessingException e){
            System.out.println(e.getMessage());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
        }while(userInt!=0);
    }

}
