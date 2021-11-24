package com.service;

import com.model.Person;
import java.util.List;

public class Sort {
    public static void sortByName(List<Person> person) {
        person.sort(Person.firstNameSorting);
        for (Person p : person) {
            System.out.println(p);
        }
    }

    public static void sortByCity(List<Person> person) {
        person.sort(Person.citySorting);
        for (Person p : person) {
            System.out.println(p);
        }
    }

    public static void sortByState(List<Person> person) {
        person.sort(Person.stateSorting);
        for (Person p : person) {
            System.out.println(p);
        }
    }

    public static void sortByZip(List<Person> person) {
        person.sort(Person.zipSorting);
        for (Person p : person) {
            System.out.println(p);
        }
    }
}