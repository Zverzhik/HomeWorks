package ru.otus.project.ucheba;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.sql.SQLOutput;

public class User {
    public String surname;
    public String name;
    public String patronymic;
    public int birthday;
    public String email;

    public User(String surname, String name, String patronymic, int birthday, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.email = email;
    }
}
