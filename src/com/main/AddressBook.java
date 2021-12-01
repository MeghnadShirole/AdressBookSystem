package com.main;

import com.com.exception.AddressBookException;
import com.model.Person;
import com.service.AddressBookService;
import com.util.FileOperations;
import com.util.InputUtil;
import java.io.IOException;
import java.util.LinkedList;


public class AddressBook {

        public static void main(String[] args) throws AddressBookException, IOException {
            final String JSON_SIMPLE_FILE_PATH = "C:\\Users\\Meghnad\\Git_Bridgelabs\\AdrdessBookSystemDay22\\Result\\AddressBook.json";
            final String OPEN_CSV_FILE_PATH = "C:\\Users\\Meghnad\\Git_Bridgelabs\\AdrdessBookSystemDay22\\Result\\AddressBook.csv";
            final int jsonSampleOperation = 1, openCSVOperation = 2;
            int operations = 0, flag = 0;
            String filePath = null;
            LinkedList<Person> personList;
            FileOperations fileOperations = new FileOperations();
            final AddressBookService addressBookService = new AddressBookService();

            System.out.println("Select Below Operations:\n1. JSON SAMPLE\n2. OPEN CSV \n");
            int option = InputUtil.getIntValue();
            switch (option) {
                case 1 -> {
                    filePath = JSON_SIMPLE_FILE_PATH;
                    operations = jsonSampleOperation;
                }
                case 2 -> {
                    filePath = OPEN_CSV_FILE_PATH;
                    operations = openCSVOperation;
                }
            }
            while (flag == 0) {
                System.out.println("--- Address Book Management ---\n");
                System.out.println("\t--MENU--");
                System.out.println("1: Add New Person");
                System.out.println("2: Display Records");
                System.out.println("3: Edit Person");
                System.out.println("4: Delete Person");
                System.out.println("5: Sort");
                System.out.println("6: Search");
                System.out.println("7: Exit\n");
                System.out.println("--- Enter Your Choice ---");
                int choice = InputUtil.getIntValue();
                switch (choice) {
                    case 1 -> {
                        personList = fileOperations.getDataInList(filePath, operations);
                        personList = addressBookService.addRecord(personList);
                        fileOperations.convertToFile(personList, filePath, operations);
                    }
                    case 2 -> {
                        LinkedList<Person> person = fileOperations.getDataInList(filePath, operations);
                        addressBookService.displayRecord(person);
                    }
                    case 3 -> {
                        personList = fileOperations.getDataInList(filePath, operations);
                        personList = addressBookService.editRecord(personList);
                        fileOperations.convertToFile(personList, filePath, operations);
                    }
                    case 4 -> {
                        personList = fileOperations.getDataInList(filePath, operations);
                        personList = addressBookService.deleteRecord(personList);
                        fileOperations.convertToFile(personList, filePath, operations);
                    }
                    case 5 -> {
                        personList = fileOperations.getDataInList(filePath, operations);
                        addressBookService.sortRecords(personList);
                    }
                    case 6 -> {
                        personList = fileOperations.getDataInList(filePath, operations);
                        addressBookService.searchInRecords(personList);
                    }
                    case 7 -> flag = 1;
                    default -> System.out.println("Please Enter Valid Option!!!");
                }
            }
        }
}
