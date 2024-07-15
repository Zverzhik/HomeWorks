package ru.otus.project.ucheba.Homework5;

public class Cat extends Animal {
    public Cat (String name, int speedRunning, int speedSwimming, int stamina, int staminaRunCost, int staminaSwimCost) {
        super(name, speedRunning, 0, stamina, 1, 0);
    }
}
