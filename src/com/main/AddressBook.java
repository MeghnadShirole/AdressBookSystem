package com.main;

import com.util.InputUtil;
import  com.model.Helper;

public class AddressBook {
    public static void main(String[] args) {
        int choice,i=0;
        final Helper help = new Helper();
        while(i==0)
        {
            System.out.println("--- Address Book Management ---\n");
            System.out.println("\t--MENU--");
            System.out.println("1: Add New Person      ");
            System.out.println("2: Display Records     ");
            System.out.println("3: Edit Person     ");
            System.out.println("4: Delete Person     ");
            System.out.println("5: Sort     ");
            System.out.println("6: Exit		       \n");
            System.out.println("--- Enter Your Choice ---");
            choice = InputUtil.getIntValue();
            switch (choice) {
                case 1 -> help.addRecord();
                case 2 -> help.displayRecord();
                case 3 -> help.editRecord();
                case 4 -> help.deleteRecord();
                case 5 -> help.sortRecords();
                case 6 -> i = 1;
                default -> System.out.println("Please Enter Valid Option!!!");
            }
        }
    }
}