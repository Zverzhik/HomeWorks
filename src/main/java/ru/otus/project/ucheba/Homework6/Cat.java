package ru.otus.project.ucheba.Homework6;

public class Cat {
    private String name;
    public int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public boolean eat(Plate plate) {
        if (!isFull) {
            isFull = plate.reduceFood(appetite);
            System.out.println(name + " поел");
            return true;
        } else {
            System.out.println(name + " сытый");
            return isFull;
        }
    }
}
