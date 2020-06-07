// К заданию с Телефонным справочником

package ru.geekbrains.lesson_7_hw_extra;

public class Person {

    private String surname;
    private String phoneNumber;

    public Person(String surname, String phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
