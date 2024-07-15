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
        if (stamina < distance) {
            System.out.println(name + " устала");
            return -1;
        } else if (stamina > distance) {
            System.out.println(name + " не устанет бегать, так как дистанция короткая для такой выносливости");
            return -1;
        }
        stamina -= distance;
        return distance / speedRunning;
    }
    public int swim(int distance) {
        if (speedSwimming == 0) {
            System.out.println(name + " не умеет плавать");
            return -1;
        } else if (stamina < distance * staminaSwimCost) {
            System.out.println(name + " устала");
            return -1;
        } else if (stamina > distance * staminaSwimCost) {
            System.out.println(name + " не устанет плавать, так как дистанция короткая для такой выносливости");
            return -1;
        }
        stamina -= distance * staminaSwimCost;
        return distance / speedSwimming;
    }

    public void info() {
        System.out.println("Вынослвость " + name + " составила: " + stamina + " условных единиц");
    }
}
