package com.main;

import com.model.Person;
import com.service.FileIO;
import com.util.InputUtil;
import com.model.Helper;

import java.util.HashMap;
import java.util.List;


public class AddressBook {
    public static void main (String[] args) {
        int choice,i=0;
        final Helper help = new Helper();
        FileIO fileIO=new FileIO();

        while(i==0)
        {
            System.out.println("--- Address Book Management ---\n");
            System.out.println("\t--MENU--");
            System.out.println("1: Add New Person      ");
            System.out.println("2: Display Records     ");
            System.out.println("3: Edit Person     ");
            System.out.println("4: Delete Person     ");
            System.out.println("5: Sort     ");
            System.out.println("6: Search");
            System.out.println("7: View");
            System.out.println("8: Count By");
            System.out.println("9: Read and write file");
            System.out.println("10: Exit		       \n");
            System.out.println("--- Enter Your Choice ---");
            choice = InputUtil.getIntValue();
            switch (choice) {
                case 1 -> help.addRecord();
                case 2 -> help.displayRecord();
                case 3 -> help.editRecord();
                case 4 -> help.deleteRecord();
                case 5 -> help.sortRecords();
                case 6 -> help.searchByCityState();
                case 7 -> help.viewByCityAndState();
                case 8 -> help.countByOption();
                case 9 ->  {
                    List<Person> personList = fileIO.takeInput();
                    fileIO.generate(personList);
                }
                case 10 -> i = 1;
                default -> System.out.println("Please Enter Valid Option!!!");
            }
        }
    }
}
