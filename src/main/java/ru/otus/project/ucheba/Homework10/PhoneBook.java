package ru.otus.project.ucheba.Homework10;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String fullname, String phoneNumber) {
        Set<String> phones = phoneBook.get(fullname);
        if (phones != null) {
            phones.add(phoneNumber);
        } else {
            phones = new HashSet<>();
            phones.add(phoneNumber);
            phoneBook.put(fullname, phones);
        }
    }
    public void find(String fullname) {
        Set<String> phones = phoneBook.get(fullname);
        if (phones != null) {
            System.out.println(phones);
        } else {
            System.out.println("Контакт не найден.");
        }
    }
    public boolean containsPhoneNumber(String phoneNumber) {
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return true;
            }
        }
     return false;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PhoneBook phoneBook1 = (PhoneBook) object;
        return Objects.equals(phoneBook, phoneBook1.phoneBook);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(phoneBook);
    }

    @Override
    public String toString() {
        return "Телефонная книжка: " + phoneBook;
    }
}
