package ru.otus.project.ucheba.Homework7.transport;

import ru.otus.project.ucheba.Homework7.TerrainType;

public class Bicycle implements Transport {
    @Override
    public boolean move(TerrainType area, int distance) {
        if (area == TerrainType.SWAMP) {
            System.out.println("Велосипед не может перемещаться по данной местности");
            return false;
        }
        System.out.println("Велосипед преодолел " + distance + " км по местности " + area.getName());
        return true;
    }

    @Override
    public String toString() {
        return "Велосипед";
    }
}
