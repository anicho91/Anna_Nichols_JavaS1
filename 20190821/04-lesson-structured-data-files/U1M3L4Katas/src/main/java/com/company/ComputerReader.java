package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class ComputerReader {
    public static void main(String[] args) {

        try{
            List<Computer> computerList =
                    new CsvToBeanBuilder<Computer>(new FileReader(
                            "computers.csv"
                    )).withType(
                            Computer.class
                    ).build().parse();

            for (Computer computer: computerList){
                System.out.println(computer.getBrand());
                System.out.println(computer.getModel());
                System.out.println(computer.getCpu());
                System.out.println(computer.getRam());
                System.out.println(computer.getStorageSize());
            }

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
