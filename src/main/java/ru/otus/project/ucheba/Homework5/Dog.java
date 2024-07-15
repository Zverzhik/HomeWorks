package ru.otus.project.ucheba.Homework5;

public class Dog extends Animal {
    public Dog (String name, int speedRunning, int speedSwimming, int stamina, int staminaRunCost, int staminaSwimCost) {
        super(name, speedRunning, speedSwimming, stamina, 1, 2);
    }
}
