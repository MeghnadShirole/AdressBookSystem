package com.model;
import com.service.Search;
import com.service.Sort;
import com.util.InputUtil;
import java.util.*;
import java.util.stream.Collectors;


public class Helper {
    // GLOBAL LIST TO STORE PERSON RECORD
    List<Person> personList = new ArrayList<>();
    //	ADD METHOD
    public void addRecord()
    {
        int i=0;
        String fname = null;
        final String lname, address, city, state, phone,zip;
        while(i==0) {
            System.out.print("Enter First Name : ");
            fname = InputUtil.getStringValue();
            if (checkExists(fname)) { //calling checkExits() method to check Fname already exists or not.
                System.out.println("Person Name Already Exists!!\nPlease enter different name...");
            }
            else {
                i=1; //if not found exits from loop & continues for next step
            }
        }
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

        personList.add(new Person(fname,lname,address,city,state,phone,zip));
    } // END of addRecord()

    //	DISPLAY METHOD
    public void displayRecord()
    {
        if (personList.isEmpty())
        {
            System.out.println("No Records!!!");
        }
        else {
            for (Person person : personList) {
                System.out.println(person);
            }
        }
    } // END OF displayRecord

    //	EDIT METHOD
    public void editRecord()
    {
        int id,choice, i=0;
        String fname,lname,address,city,state,phone,zip;
        for(Person person: personList)
        {
            System.out.println("ID: #"+ personList.indexOf(person)+" : "+person);
        }
        System.out.print("\nEnter #ID to Edit Contact : ");
        id = InputUtil.getIntValue();
        System.out.println(personList.get(id));
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
                    personList.get(id).setAddress(address);
                }
                case 2 -> {
                    System.out.print("Enter new City : ");
                    city = InputUtil.getStringValue();
                    personList.get(id).setCity(city);
                }
                case 3 -> {
                    System.out.print("Enter new State : ");
                    state = InputUtil.getStringValue();
                    personList.get(id).setState(state);
                }
                case 4 -> {
                    System.out.print("Enter new Phone : ");
                    phone = InputUtil.getStringValue();
                    personList.get(id).setPhone(phone);
                }
                case 5 -> {
                    System.out.print("Enter new Zip Code : ");
                    zip = InputUtil.getStringValue();
                    personList.get(id).setZip(zip);
                }
                case 6 -> i = 1;
                default -> System.out.println("Please Enter Valid Option");
            }
            System.out.println(personList.get(id));
        }
    } //end of edit() method

    //	DELETE METHOD
    public void deleteRecord()
    {
        int id;
        for(Person p: personList)
        {
            System.out.println("ID: #"+ personList.indexOf(p)+" : "+p);
        }
        System.out.print("\nEnter #ID to delete Contact : ");
        id = InputUtil.getIntValue();
        personList.remove(id);
    } //end of delete() method

    //    This Method will Sort the Address book by Name, city, state and Zip
    public void sortRecords() {
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
                Sort.sortByName(personList);
                break;
            case 2:
                Sort.sortByCity(personList);
                break;
            case 3:
                Sort.sortByState(personList);
                break;
            case 4:
                Sort.sortByZip(personList);
                break;
            case 5:
                return;
            default:
                System.out.println("Please Enter Valid Option...");
        }
    } //End of Sort() Method

    //    This Method Will Search Person By City or State
    public void searchByCityState()
    {
        int choice;
        System.out.println("""
                Search By
                1: City
                2: State""");
        choice=InputUtil.getIntValue();
        switch (choice)
        {
            case 1 :
                Search.searchByCity(personList);
                break;
            case 2 :
                Search.searchByState(personList);
                break;
            default:
                System.out.println("Enter Valid Option");
        }
    }

    //  This Method will View Person by City and State
    public void viewByCityAndState()
    {
        Dictionary<String ,String> cityDict = createCityDict();
        Dictionary<String ,String> stateDict = createStateDict();
        final String city,state;
        System.out.println("Enter City");
        city=InputUtil.getStringValue();
        System.out.println("Enter State");
        state=InputUtil.getStringValue();
        Search.searchByCityAndState(cityDict,stateDict);
    } //End of viewByCityAndState() Method

    //    Create City Dictionary
    public Dictionary<String,String> createCityDict()
    {
        Dictionary<String,String> cityDict = new Hashtable<>();
        for (Person person: personList)
        {
            cityDict.put(person.getFname(),person.getCity());
        }
        return cityDict;
    }

    //    Create State Dictionary
    public Dictionary<String,String> createStateDict()
    {
        Dictionary<String,String> stateDict = new Hashtable<>();
        for (Person person: personList)
        {
            stateDict.put(person.getFname(),person.getState());
        }
        return stateDict;
    }

    public void countByOption() {
        System.out.println("1. Count City ");
        System.out.println("2. Count State");
        System.out.println("Enter Your Choice : ");
        int choice = InputUtil.getIntValue();
        switch (choice) {
            case 1 -> {
                Map<String, Long> countCity = personList.stream()
                        .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
                System.out.println(countCity + "\n");
            }
            case 2 -> {
                Map<String, Long> countState = personList.stream()
                        .collect(Collectors.groupingBy(Person::getState, Collectors.counting()));
                System.out.println(countState + "\n");
            }
            default -> System.out.println("Invalid Option");
        }
    }

    //    this function will check for duplicate users
    public boolean checkExists(String fname)
    {
        int flag=0;
        for (Person p: personList)
        {
            if (p.getFname().equals(fname))
            {
                flag=1;
                break;
            }
        }
        return flag == 1;
    }
}