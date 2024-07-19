package ru.otus.project.ucheba.Homework7.transport;

import ru.otus.project.ucheba.Homework7.TerrainType;

public class Car implements Transport {
    private int fuel;
    private final int fuelFlow;

    public Car(int fuel, int fuelFlow) {
        this.fuel = fuel;
        this.fuelFlow = fuelFlow;
    }

    @Override
    public boolean move(TerrainType area, int distance) {
        if (area == TerrainType.DENSEFORREST) {
            System.out.println("Машина не может перемещаться по данной местности");
            return false;
        }
        if (area == TerrainType.SWAMP) {
            System.out.println("Машина не может перемещаться по данной местности");
            return false;
        }
        if (fuel <= 0) {
            System.out.println("У машины нет топлива, движение не возможно");
            return false;
        }
        if (fuel < (distance * fuelFlow) / 100) {
            System.out.println("У машины не хватит топлива, чтобы преодолеть " + distance + " км" + "\nКоличество топлива: " + fuel + " л");
            return false;
        }
        fuel -= (distance * fuelFlow) / 100;
        System.out.println("Машина преодолела " + distance + " км по местности " + area.getName() + "\nУшло на такую поездку " + ((distance * fuelFlow) / 100) + " л" + "\nОстаток топлива: " + fuel + " л");
        return true;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "Машина";
    }
}
