package ru.otus.project.ucheba.Homework7.transport;

import ru.otus.project.ucheba.Homework7.TerrainType;

public class AllTerrainVehicle implements Transport {
    private int fuel;
    private final int fuelFlow;

    public AllTerrainVehicle(int fuel, int fuelFlow) {
        this.fuel = fuel;
        this.fuelFlow = fuelFlow;
    }

    @Override
    public boolean move(TerrainType area, int distance) {
        if (fuel <= 0) {
            System.out.println("У вездехода нет топлива, движение не возможно");
            return false;
        }
        if (fuel < (distance * fuelFlow) / 100) {
            System.out.println("У вездехода не хватит топлива, чтобы преодолеть " + distance + " км" + "\nКоличество топлива: " + fuel + " л");
            return false;
        }
        fuel -= (distance * fuelFlow) / 100;
        System.out.println("Вездеход преодолел " + distance + " км по местности " + area.getName() + "\nУшло на такую поездку " + ((distance * fuelFlow) / 100) + " л" + "\nОстаток топлива: " + fuel + " л");
        return true;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "Вездеход";
    }
}
