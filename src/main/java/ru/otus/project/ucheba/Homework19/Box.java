package ru.otus.project.ucheba.Homework19;

import java.util.*;

public class Box<T extends Fruit> {
    private final List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    @SafeVarargs
    public final void addFruit(T... fruits) {
        Objects.requireNonNull(fruits, "Не может быть null");
        if (fruits.length == 0) {
            return;
        }
        this.fruits.addAll(List.of(fruits));
    }

    public int weight() {
        if (fruits.isEmpty()) {
            return 0;
        }
        int totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> box) {
        Objects.requireNonNull(box, "Не может быть null");
        if (box == this) {
            return true;
        }
        return Math.abs(this.weight() - box.weight()) < 0.0001;
    }

    public void pourOverFruits(Box<? super T> box) {
        Objects.requireNonNull(box, "Не может быть null");
        if (box == this) {
            System.out.println("Некорректно! Нельзя коробку пересыпать саму в себя!");
            return;
        }
        if (box.fruits.isEmpty()) {
            Collections.reverse(this.fruits);
        }
        box.fruits.addAll(0, this.fruits);
        this.fruits.clear();
    }

    public List<T> getFruits() {
        return fruits;
    }
}
