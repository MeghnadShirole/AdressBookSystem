package com.service;

import com.com.exception.AddressBookException;
import com.enums.sortOptions;
import com.model.Person;
import com.util.InputUtil;
import com.util.WriteToCSV;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*Helper Class to Perform AddressBook Operations
 * Add, Display, Edit, Delete, Search, Sort
 */
public class AddressBookService implements IAddressBookService {

    /*Method Search the Person By City
     * @Param Person List
     */
    public static void searchByCity(List<Person> person) {
        String search;
        List<Person> matches = new ArrayList<>();
        System.out.println("Enter First Name to search : ");
        search = InputUtil.getStringValue();
        int flag = 0;
        for (Person p : person) {
            if (p.getCity().equalsIgnoreCase(search)) {
                flag = 1;
                matches.add(p);
            }
        }
        if (flag == 1) {
            System.out.println("...Match Found...");
            for (Person p : matches) {
                System.out.println(p);
            }
        } else {
            System.out.println("Match Not Found!!!");
        }
    }

    /*Method Search the Person By State
     * @Param Person List
     */
    public static void searchByState(List<Person> person) {
        String search;
        int flag = 0;
        List<Person> matches = new ArrayList<>();
        System.out.println("Enter First Name to search : ");
        search = InputUtil.getStringValue();
        for (Person p : person) {
            if (p.getState().equalsIgnoreCase(search)) {
                flag = 1;
                matches.add(p);
            }
        }
        if (flag == 1) {
            System.out.println("...Match Found...");
            for (Person p : matches) {
                System.out.println(p);
            }
        } else {
            System.out.println("Match Not Found!!!");
        }
    }

    /*Method Sort the Records
     * @Param Person List
     */
    public static void sortData(List<Person> person, sortOptions sortOptions) {
        person.stream().sorted(sortOptions.comparator).forEach(System.out::println);
    }

    /*Method Add Person Record*/
    public LinkedList<Person> addRecord(LinkedList<Person> personList) {
        int flag = 0;
        String firstName = null;
        final String lastName, address, city, state, phone, zip;
        while (flag == 0) {
            System.out.print("Enter First Name : ");
            firstName = InputUtil.getStringValue();
            if (checkExists(firstName, personList)) {
                System.out.println("Person Name Already Exists!!\nPlease enter different name...");
            } else {
                flag = 1;
            }
        }
        System.out.print("Enter Last Name : ");
        lastName = InputUtil.getStringValue();
        System.out.print("Enter Phone Number : ");
        phone = InputUtil.getStringValue();
        System.out.print("Enter Address : ");
        address = InputUtil.getStringValue();
        System.out.print("Enter city : ");
        city = InputUtil.getStringValue();
        System.out.print("Enter zip : ");
        zip = InputUtil.getStringValue();
        System.out.print("Enter state : ");
        state = InputUtil.getStringValue();
        Person person = new Person(firstName, lastName, address, city, state, zip, phone);
        personList.add(person);
        return personList;
    }

    /*Method to Display Person Records*/
    public void displayRecord(LinkedList<Person> person) {
        if (person.isEmpty()) {
            System.out.println("No Records To Display!!!");
        } else {
            person.forEach(System.out::println);
        }
    }

    /*Method to Edit Person Record*/
    public LinkedList<Person> editRecord(LinkedList<Person> person) throws AddressBookException {
        int id, flag = 0;
        String address, city, state, phone, zip;
        try {
            if (person.isEmpty()) {
                System.out.println("No Records To Edit!!!");
            } else {
                for (Person person1 : person) {
                    System.out.println("ID: #" + person.indexOf(person1) + " : " + person1);
                }
                System.out.print("\nEnter #ID to Edit Contact : ");
                id = InputUtil.getIntValue();
                System.out.println(person.get(id));
                while (flag == 0) {
                    System.out.println("""
                            What You Want to edit...
                            \t1: Address
                            \t2: city
                            \t3: State
                            \t4: Phone
                            \t5: Zip Code
                            \t6. Save And Exit
                            """);
                    int choice = InputUtil.getIntValue();
                    switch (choice) {
                        case 1 -> {
                            System.out.print("Enter new Address : ");
                            address = InputUtil.getStringValue();
                            person.get(id).setAddress(address);
                        }
                        case 2 -> {
                            System.out.print("Enter new City : ");
                            city = InputUtil.getStringValue();
                            person.get(id).setCity(city);
                        }
                        case 3 -> {
                            System.out.print("Enter new State : ");
                            state = InputUtil.getStringValue();
                            person.get(id).setState(state);
                        }
                        case 4 -> {
                            System.out.print("Enter new Phone : ");
                            phone = InputUtil.getStringValue();
                            person.get(id).setPhone(phone);
                        }
                        case 5 -> {
                            System.out.print("Enter new Zip Code : ");
                            zip = InputUtil.getStringValue();
                            person.get(id).setZip(zip);
                        }
                        case 6 -> flag = 1;
                        default -> System.out.println("Please Enter Valid Option");
                    }
                    System.out.println(person.get(id));
                }
            }
        } catch (IndexOutOfBoundsException e) {
            throw new AddressBookException("Entered Wrong #ID",
                    AddressBookException.exceptionType.ENTERED_WRONG_ID);
        }
        return person;
    }

    /*Method to Delete Person Record*/
    public LinkedList<Person> deleteRecord(LinkedList<Person> personList) throws AddressBookException {
        try {
            int id;
            if (personList.isEmpty()) {
                System.out.println("No Records To Delete!!!");
            } else {
                personList.stream().map(p -> "ID: #" + personList.indexOf(p) + " : " + p).forEach(System.out::println);
                System.out.print("\nEnter #ID to delete Contact : ");
                id = InputUtil.getIntValue();
                personList.remove(id);
                WriteToCSV.writeFromDelete(personList);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new AddressBookException("Entered Wrong #ID",
                    AddressBookException.exceptionType.ENTERED_WRONG_ID);
        }
        return personList;
    }

    /*Method for Sort Menu*/
    public void sortRecords(LinkedList<Person> personList) {
        System.out.println("""
                Sort By...
                1: First Name
                2: City
                3: State
                4: Zip Code
                5: Back""");
        int choice = InputUtil.getIntValue();
        switch (choice) {
            case 1:
                sortData(personList, sortOptions.NAME);
                break;
            case 2:
                sortData(personList, sortOptions.CITY);
                break;
            case 3:
                sortData(personList, sortOptions.STATE);
                break;
            case 4:
                sortData(personList, sortOptions.ZIP);
                break;
            case 5:
                return;
            default:
                System.out.println("Please Enter Valid Option...");
        }
    }

    /*Method to Check Duplication of First Name
     * @Param FirstName
     */
    public boolean checkExists(String firstName, LinkedList<Person> person) {
        int flag = person.stream()
                .anyMatch(p -> p.getFirstName().equalsIgnoreCase(firstName)) ? 1 : 0;
        return flag == 1;
    }

    /*Method for Search Menu*/
    public void searchInRecords(LinkedList<Person> person) {
        int flag = 0;
        while (flag == 0) {
            System.out.println("""
                    1. Search By City
                    2. Search By State
                    3. Back
                    Choose Your Option""");
            int choice = InputUtil.getIntValue();
            switch (choice) {
                case 1 -> searchByCity(person);
                case 2 -> searchByState(person);
                case 3 -> flag = 1;
                default -> System.out.println("Please Enter Correct Option...");
            }
        }
    }
}