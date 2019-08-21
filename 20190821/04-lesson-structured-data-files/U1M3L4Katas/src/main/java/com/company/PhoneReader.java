package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PhoneReader {
    public static void main(String[] args) {

        List<Phones> phoneList;

        try {
            ObjectMapper mapper = new XmlMapper();

            phoneList = mapper.readValue(new File("phones.xml"),
                    new TypeReference<List<Phones>>() {
                    });

            for (Phones phone : phoneList) {
                System.out.println(phone.getBrand());
                System.out.println(phone.getModel());
                System.out.println(phone.getProcessor());
                System.out.println(phone.getStorage());
                System.out.println(phone.getPrice());
            }

        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
