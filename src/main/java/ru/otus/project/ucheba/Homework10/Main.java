package ru.otus.project.ucheba.Homework10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import ru.otus.project.ucheba.Homework10.PhoneBook;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

     phoneBook.add("Ivanov Ivan Ivanovich","+79851234567");
     phoneBook.add("Petrov Petr Petrovich","+79154328709");
     phoneBook.add("Leonov Leo Leonovich","+79231456498");
     phoneBook.add("Abramov Abram Abramovich","+79165248965");
     phoneBook.add("Kirillov Kirill Kirillovich","+79231456498");
     phoneBook.add("Leonov Leo Leonovich","+79120987654");
     System.out.println(phoneBook);

     phoneBook.find("Ivanov Ivan Ivanovich");
     phoneBook.find("Leonov Leo Leonovich");

     System.out.println(phoneBook.containsPhoneNumber("+79120987654"));
     System.out.println(phoneBook.containsPhoneNumber("+7912098"));

    }
}
