package com.service;

import com.model.Person;
import com.util.InputUtil;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Search {
    public static void searchByCityAndState(Dictionary<String,String> cityDict,
                                            Dictionary<String,String> stateDict)
    {
        System.out.println("In Progress...");
    }

    public static void searchByCity(List<Person> person)
    {
        String search;
        int flag = 0;
        List<Person> matches = new ArrayList<>();
        System.out.println("Enter First Name to search : ");
        search = InputUtil.getStringValue();
        for(Person p: person)
        {
            if(p.getCity().equalsIgnoreCase(search))
            {

                flag = 1;
                matches.add(p);
            }
        }
        if(flag == 1)
        {
            System.out.println("...Match Found...");
            for(Person p: matches)
            {
                System.out.println(p);
            }
        }
        else
        {
            System.out.println("Match Not Found!!!");
        }
    }
    public static void searchByState(List<Person> person)
    {
        String search;
        int flag = 0;
        List<Person> matches = new ArrayList<>();
        System.out.println("Enter First Name to search : ");
        search = InputUtil.getStringValue();
        for(Person p: person)
        {
            if(p.getState().equalsIgnoreCase(search))
            {

                flag = 1;
                matches.add(p);
            }
        }
        if(flag == 1)
        {
            System.out.println("...Match Found...");
            for(Person p: matches)
            {
                System.out.println(p);
            }
        }
        else
        {
            System.out.println("Match Not Found!!!");
        }
    }
}