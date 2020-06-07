/*
* Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
* телефонных номеров. В этот телефонный справочник с помощью метода add() можно
* добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
* учесть, что под одной фамилией может быть несколько телефонов (в случае
* однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 */

package ru.geekbrains.lesson_7_hw_extra;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    public static HashMap<Person, String> phoneBook = new HashMap<>();

    public static void main(String[] args) {

        add("Ivanov", "+7-903-767-90-87");  // все совпадения абсолютно случайны
        add("Petrov", "+7-965-123-98-65");
        add("Ivanov", "+7-916-564-90-37");
        add("Petrov", "+7-925-255-73-77");

        System.out.println(get("Ivanov"));
        System.out.println(get("Petrov"));
    }

    public static void add(String surname, String phoneNumber) {

        phoneBook.put(new Person(surname, phoneNumber), phoneNumber);
    }

    public static HashMap<String, ArrayList<String>> get(String surname) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        ArrayList<String> phoneNumbersList = new ArrayList<>();

        for (Person person : phoneBook.keySet()) {
            if (person.getSurname().equals(surname)) {
                phoneNumbersList.add(person.getPhoneNumber());
            }
            hashMap.put(surname, phoneNumbersList);
        }
        return hashMap;
    }
}
