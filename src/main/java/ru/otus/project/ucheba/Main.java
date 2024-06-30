package ru.otus.project.ucheba;

public class Main {


    public static void main(String[] args) {
        User user1 = new User("Петров","Петр","Петрович",1980,"p@mail.ru");
        System.out.println("ФИО: " + user1.surname + " " + user1.name + " " + user1.patronymic);
        System.out.println("Год рождения: " + user1.birthday);
        System.out.println("e-mail: " + user1.email);

        User[] users = {
                new User("Иванов", "Иван", "Иванович", 1990, "i@mail.ru"),
                new User("Петров", "Петр", "Петрович", 1969, "p@mail.ru"),
                new User("Комаров", "Федор", "Федорович", 1968, "f@mail.ru"),
                new User("Лапин", "Олег", "Олегович", 2000, "o@mail.ru"),
                new User("Власов", "Виталий", "Витальевич", 1966, "v@mail.ru"),
                new User("Прусин", "Алексей", "Алексеевич", 2010, "a@mail.ru"),
                new User("Войков", "Михаил", "Михайлович", 1964, "m@mail.ru"),
                new User("Оганов", "Сергей", "Сергеевич", 1963, "s@mail.ru"),
                new User("Давыдов", "Данил", "Данилович", 2001, "d@mail.ru"),
                new User("Жуков", "Глеб", "Глебович", 1961, "g@mail.ru"),
        };
            for (int i = 0; i < users.length; i++) {
                if ((2024 - users[i].birthday) > 40) {
                    System.out.println(users[i]);
                }
            }
        }
    }