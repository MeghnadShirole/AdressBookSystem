package com.model;

import com.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    // GLOBAL LIST TO STORE PERSON RECORD
    List<Person> PERSON = new ArrayList<>();
    //	ADD METHOD
    public void addRecord()
    {
        final String fname, lname, address, city, state, phone,zip;

        System.out.print("Enter First Name : ");
        fname = InputUtil.getStringValue();
        System.out.print("Enter Last Name : ");
        lname = InputUtil.getStringValue();
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

        PERSON.add(new Person(fname,lname,address,city,state,phone,zip));
    } // END of addRecord()

    //	DISPLAY METHOD
    public void displayRecord()
    {
        if (PERSON.isEmpty())
        {
            System.out.println("No Records!!!");
        }
        else {
            for (Person person : PERSON) {
                System.out.println(person);
            }
        }
    } // END OF displayRecord

    //	EDIT METHOD
    public void editRecord()
    {
        int id,choice, i=0;
        String fname,lname,address,city,state,phone,zip;
        for(Person person: PERSON)
        {
            System.out.println("ID: #"+PERSON.indexOf(person)+" : "+person);
        }
        System.out.print("\nEnter #ID to Edit Contact : ");
        id = InputUtil.getIntValue();
        System.out.println(PERSON.get(id));
        while(i==0) {
            System.out.println("""
                    What You Want to edit...
                    \t1: Address
                    \t2: city
                    \t3: State
                    \t4: Phone
                    \t5: Zip Code
                    \t6. Save And Exit
                    """);
            choice = InputUtil.getIntValue();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter new Address : ");
                    address = InputUtil.getStringValue();
                    PERSON.get(id).setAddress(address);
                }
                case 2 -> {
                    System.out.print("Enter new City : ");
                    city = InputUtil.getStringValue();
                    PERSON.get(id).setCity(city);
                }
                case 3 -> {
                    System.out.print("Enter new State : ");
                    state = InputUtil.getStringValue();
                    PERSON.get(id).setState(state);
                }
                case 4 -> {
                    System.out.print("Enter new Phone : ");
                    phone = InputUtil.getStringValue();
                    PERSON.get(id).setPhone(phone);
                }
                case 5 -> {
                    System.out.print("Enter new Zip Code : ");
                    zip = InputUtil.getStringValue();
                    PERSON.get(id).setZip(zip);
                }
                case 6 -> i = 1;
                default -> System.out.println("Please Enter Valid Option");
            }
            System.out.println(PERSON.get(id));
        }
    } //end of edit() method

    //	DELETE METHOD
    public void deleteRecord()
    {
        int id;
        for(Person p: PERSON)
        {
            System.out.println("ID: #"+PERSON.indexOf(p)+" : "+p);
        }
        System.out.print("\nEnter #ID to delete Contact : ");
        id = InputUtil.getIntValue();
        PERSON.remove(id);
    }
}