package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.*;
import java.util.List;

public class CSVWriteAndReadCreate {
    public static void main(String[] args) {

        try{
            List<Car> carList =
                    new CsvToBeanBuilder<Car>(new FileReader(
                            "CSVWriteAndRead.csv"
                    )).withType(
                            Car.class
                    ).build().parse();

            for (Car car: carList){
                System.out.println(car.getYear());
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getColor());
            }

            Writer writer = new FileWriter("new_CSVWriteAndRead.csv");

            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(carList);
            writer.close();;
        }catch (FileNotFoundException e){

        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
