package ru.otus.project.ucheba.Homework19;

public class Apple extends Fruit {
    private final String name;

    public Apple(int weight, String name) {
        super(weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
