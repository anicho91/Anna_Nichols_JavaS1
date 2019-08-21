package com.company;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLWriteAndRead {

    public static void main(String[] args) throws JsonProcessingException {

        PrintWriter writer = null;

        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Camry");
        car.setYear(2012);
        car.setColor("Blue");

        Car car2 = new Car();
        car2.setMake("Honda");
        car2.setModel("Civic");
        car2.setYear(2001);
        car2.setColor("Silver");

        Car car3 = new Car();
        car3.setMake("Jeep");
        car3.setModel("Wrangler");
        car3.setYear(2009);
        car3.setColor("Rust");

        Car car4 = new Car();
        car4.setMake("Tesla");
        car4.setModel("Roadster");
        car4.setYear(2018);
        car4.setColor("Black");

        Car car5 = new Car();
        car5.setMake("Ford");
        car5.setModel("Mustang");
        car5.setYear(1964);
        car5.setColor("Red");


        List<Car> carList = new ArrayList<>();

        carList.add(car);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);

        try {
            ObjectMapper mapper = new XmlMapper();

            String xmlCarList = mapper.writeValueAsString(carList);

            System.out.println(xmlCarList);

            writer = new PrintWriter(new FileWriter("XMLWriteAndRead.xml"));

            writer.println(xmlCarList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

        try{
            ObjectMapper mapper = new XmlMapper();

            carList = mapper.readValue(new File("XMLWriteAndRead.xml"),
                    new TypeReference<List<Car>>(){});

            for(Car cars: carList){
                System.out.println(cars.getMake());
                System.out.println(cars.getModel());
                System.out.println(cars.getYear());
                System.out.println(cars.getColor());
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
