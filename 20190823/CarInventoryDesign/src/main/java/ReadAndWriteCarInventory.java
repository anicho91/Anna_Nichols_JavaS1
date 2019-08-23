//import com.opencsv.bean.CsvToBeanBuilder;
//import com.opencsv.bean.StatefulBeanToCsv;
//import com.opencsv.bean.StatefulBeanToCsvBuilder;
//import com.opencsv.exceptions.CsvDataTypeMismatchException;
//import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
//
//import java.io.*;
//import java.util.*;
//
//public class ReadAndWriteCarInventory {
//
//    public static void main(String[] args) {
//
//        try{
//            List<Car> carList =
//                    new CsvToBeanBuilder<Car>(new FileReader(
//                            "cars.csv"
//                    )).withType(
//                            Car.class
//                    ).build().parse();
//
//            Scanner scan = new Scanner(System.in);
//
//            System.out.println("What would you like to do?");
//            System.out.println("1. Add a car \t 2. Remove a car \n3. See all cars available \t 4. Search for a car");
//            String userInput = scan.nextLine();
//            int userInt = Integer.parseInt(userInput);
//
//            if(userInt == 1){
//                String make2;
//                String model2;
//                int year2;
//                String color2;
//                int miles2;
//
//                System.out.println("Input information you want to add");
//
//                System.out.println("Input Make");
//                make2 = scan.nextLine();
//
//                System.out.println("Input Model");
//                model2 = scan.nextLine();
//
//                System.out.println("Input Year");
//                String userI2 = scan.nextLine();
//                year2 = Integer.parseInt(userI2);
//
//                System.out.println("Input Color");
//                color2 = scan.nextLine();
//
//                System.out.println("Input Miles");
//                userI2 = scan.nextLine();
//                miles2 = Integer.parseInt(userI2);
//
//                System.out.println("You input: " + make2 + " " + model2 + " " +year2 +
//                        " " + color2 + " " + miles2);
//
//                carList.add(new Car(make2, model2, year2, color2, miles2));
//
//            }else if(userInt == 2){
//
//                String make2;
//                String model2;
//                int year2;
//                String color2;
//                int miles2;
//
//                System.out.println("Input information you want to remove");
//
//                System.out.println("Input Make");
//                make2 = scan.nextLine();
//
//                System.out.println("Input Model");
//                model2 = scan.nextLine();
//
//                System.out.println("Input Year");
//                String userI2 = scan.nextLine();
//                year2 = Integer.parseInt(userI2);
//
//                System.out.println("Input Color");
//                color2 = scan.nextLine();
//
//                System.out.println("Input Miles");
//                userI2 = scan.nextLine();
//                miles2 = Integer.parseInt(userI2);
//
//                System.out.println("You input: " + make2 + " " + model2 + " " +year2 +
//                        " " + color2 + " " + miles2);
//
//                carList. remove(carList.lastIndexOf(make2), model2, year2, color2, miles2);
//
//            }else if(userInt == 3){
//
//            }else if(userInt == 4){
//
//            }else{
//                System.out.println("Invalid Selection");
//            }
//
//            Writer writer = new FileWriter("cars.csv");
//
//            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
//            beanToCsv.write(carList);
//            writer.close();;
//        }catch (FileNotFoundException e){
//
//        } catch (CsvRequiredFieldEmptyException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (CsvDataTypeMismatchException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
