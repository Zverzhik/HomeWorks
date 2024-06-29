package ru.otus.project.ucheba;


import static ru.otus.project.ucheba.User.userAge;

public class Main {


    public static void main(String[] args) {

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
        userAge(users);
    }
}
