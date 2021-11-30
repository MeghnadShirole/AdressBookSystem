package com.service;

import com.util.FileUtil;
import com.model.Person;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileIO {

    FileUtil fileUtil;

    public FileIO() {
        String IP_FILE_PATH = "C:\\Users\\Meghnad\\Git_Bridgelabs\\AddressBookSystemDay22\\Result\\ab.txt";
        fileUtil = new FileUtil(IP_FILE_PATH);
    }

    public void generate(List<Person> personList){

        personList.forEach(1, Person -> {
            try {
                fileUtil.writeData(personList);
            } catch (IOException ioException) {
                System.err.println(ioException.getMessage());
            }
        });
    }

    public List<Person> takeInput() {
        List<String> lines;
        List<Person> personList = null;
        try {
            lines = fileUtil.readDataFromFile();
            personList = lines.stream().map(line -> {
                String[] addRecord = line.split(" ");
                return mapPersonData(addRecord);
            }).collect(Collectors.toList());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return personList;
    }

    private Person mapPersonData(String[] empRecord) {
        Person person=new Person();
        person.setFname(empRecord[0]);
        person.setLname(empRecord[1]);
        person.setAddress(empRecord[2]);
        person.setCity(empRecord[3]);
        person.setPhone(empRecord[4]);
        person.setZip(empRecord[5]);
        return person;
    }

}
