package ru.otus.project.ucheba.Homework6;

public class Plate {
    private int foodAmountMax;
    public int foodAmountCurrent;

    public Plate(int foodAmountMax, int foodAmountCurrent) {
        this.foodAmountMax = foodAmountMax;
        this.foodAmountCurrent = foodAmountCurrent;
    }

    public void addFood(int food) {
        if (food < 0) {
            System.out.println("Отрицательное количество еды добавить невозможно");
            return;
        } else if (foodAmountCurrent + food > foodAmountMax) {
            System.out.println("Данное количество еды не влезает в тарелку");
        } else {
            foodAmountCurrent += food;
        }
    }

    public boolean reduceFood(int food) {
        if (foodAmountCurrent - food >= 0) {
            foodAmountCurrent -= food;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "В тарелке макисмальное количество еды: " + foodAmountMax +
                ", текущее количество: " + foodAmountCurrent;
    }
}
