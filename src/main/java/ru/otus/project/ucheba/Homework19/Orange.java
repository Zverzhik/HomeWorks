package ru.otus.project.ucheba.Homework19;

public class Orange extends Fruit {
    private final String name;

    public Orange(int weight, String name) {
        super(weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
