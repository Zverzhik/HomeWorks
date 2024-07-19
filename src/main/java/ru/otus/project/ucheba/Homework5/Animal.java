package ru.otus.project.ucheba.Homework5;

public class Animal {
    String name;
    int speedRunning;
    int speedSwimming;
    int stamina;
    int staminaRunCost;
    int staminaSwimCost;

    public Animal (String name, int speedRunning, int speedSwimming, int stamina, int staminaRunCost, int staminaSwimCost) {
        this.name = name;
        this.speedRunning = speedRunning;
        this.speedSwimming = speedSwimming;
        this.stamina = stamina;
        this.staminaRunCost = staminaRunCost;
        this.staminaSwimCost = staminaSwimCost;
    }

    public int run(int distance) {
        if (stamina < distance * staminaRunCost) {
            System.out.println(name + " устала");
            return -1;
        }
        stamina -= distance * staminaRunCost;
        return distance / speedRunning;
    }

    public int swim(int distance) {
        if (speedSwimming == 0) {
            System.out.println(name + " не умеет плавать");
            return -1;
        }
        if (stamina < distance * staminaSwimCost) {
            System.out.println(name + " устала");
            return -1;
        }
        stamina -= distance * staminaSwimCost;
        return distance / speedSwimming;
    }

    public void info() {
        System.out.println("Выносливость " + name + " составила: " + stamina + " условных единиц");
    }
}
