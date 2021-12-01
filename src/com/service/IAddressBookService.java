package com.service;

import com.com.exception.AddressBookException;
import com.model.Person;

import java.util.LinkedList;

public interface IAddressBookService {

    LinkedList<Person> addRecord(LinkedList<Person> personList);

    LinkedList<Person> editRecord(LinkedList<Person> person) throws AddressBookException;

    void displayRecord(LinkedList<Person> person);

    LinkedList<Person> deleteRecord(LinkedList<Person> personList) throws AddressBookException;

    void sortRecords(LinkedList<Person> person);

    void searchInRecords(LinkedList<Person> person);

    boolean checkExists(String firstName, LinkedList<Person> person);
}