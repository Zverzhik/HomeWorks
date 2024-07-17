package ru.otus.project.ucheba.Homework6;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Loo", 42),
                new Cat("Neo", 20),
                new Cat("Moris", 80),
                new Cat("Stray", 35),
                new Cat("Kiwi", 100),
        };

        Plate plate = new Plate(200, 200);
        System.out.println(plate);

        for (int i = 0; i < cats.length; i++) {
            if (plate.foodAmountCurrent > cats[i].appetite) {
                cats[i].eat(plate);
            } else if (plate.foodAmountCurrent < cats[i].appetite) {
                System.out.println("Следующему коту не хватает еды, добавьте еду в тарелкуы");
            }
        }
    }
}