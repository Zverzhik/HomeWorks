package ru.otus.project;
public class HomeWork1 {
    public static void main(String[] args) {

        greetings();
        checkSign();
        selectColor();
        compareNumbers();
        addOrSubtractAndPrint (7,2,false);
    }
    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }
    public static void checkSign() {
        int a = 5;
        int b = -2;
        int c = -6;
        int result = a + b + c;
        if (result >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void selectColor() {
        int data = 21;
        if (data <= 10) {
            System.out.println("Красный");
        } else if ( data > 10 && data <= 20) {
            System.out.println("Жёлтый");
        } else if (data > 20) {
            System.out.println("Зелёный");
        }
    }
    public static void compareNumbers() {
        int a = 3;
        int b = -4;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    public static void addOrSubtractAndPrint (int initValue, int delta, boolean increment) {
        if (increment == true) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }
}
