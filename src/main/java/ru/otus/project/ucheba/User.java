package ru.otus.project.ucheba;

public class User {
    private String фамилия;
    private String имя;
    private String отчество;
    private int год_рождения;
    private String email;

    public User(String фамилия, String имя, String отчество, int год_рождения, String email) {
        this.фамилия = фамилия;
        this.имя = имя;
        this.отчество = отчество;
        this.год_рождения = год_рождения;
        this.email = email;
    }

    public static void main(String[] args) {
        User user1 = new User("Петров", "Петр", "Петрович", 1980, "petrovich@mail.ru");
        System.out.println("ФИО: " + user1.фамилия + " " + user1.имя + " " + user1.отчество);
        System.out.println("Год рождения: " + user1.год_рождения);
        System.out.println("e-mail: " + user1.email);
    }

    public static void userAge(User[] users) {
        for (int i = 0; i < users.length; i++) {
            if ((2024 - users[i].год_рождения) > 40) {
                System.out.println(users[i]);
            }
        }
    }
}
