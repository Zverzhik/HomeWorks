package ru.otus.project.ucheba.Homework7.transport;

import ru.otus.project.ucheba.Homework7.TerrainType;

public class Horse implements Transport {
    private int energy;
    private final int energyWaste;

    public Horse(int energy, int energyWaste) {
        this.energy = energy;
        this.energyWaste = energyWaste;
    }

    @Override
    public boolean move(TerrainType area, int distance) {
        int energyRequired = distance * energyWaste;
        if (area == TerrainType.SWAMP) {
            System.out.println("Лошадь не может перемещаться по данной местности");
            return false;
        }
        if (energy <= 0) {
            System.out.println("У лошади не хватает энергии, движение не возможно");
            return false;
        }
        if (energy < energyRequired) {
            System.out.println("У лошади не хватит энергии, чтобы преодолеть " + distance + " км" + "\nКоличество энергии: " + energy + " лошадиных сил");
            return false;
        }
        energy -= energyRequired;
        System.out.println("Лошадь преодолела " + distance + " км по местности " + area.getName() + "\nУшло на такую поездку " + (distance * energyWaste) + " лошадиных сил" + "\nОстаток энергии: " + energy + " лошадиных сил");
        return true;
    }

    public int getEnergy() {
        return energy;
    }
    @Override
    public String toString() {
        return "Лошадь";
    }
}
