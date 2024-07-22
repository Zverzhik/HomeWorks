package ru.otus.project.ucheba.Homework8;

public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {{"1","2","3","4"},{"6","4","2","0"},{"0","2","1","4"},{"9","1","5","1"}};
        String[][] errorSizeArray = {{"1","2","3","4"},{"6","4","2"},{"0","2"},{"9","1","5","1"}};
        String[][] errorCharArray = {{"1","2","3","4"},{"6","9","2","0"},{"0","2","1","3"},{"9","cat","5","1"}};
        try {
            System.out.println("Сумма всех элементов массива равна " + Converter.convectrInt(correctArray));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Сумма всех элементов массива равна " + Converter.convectrInt(errorSizeArray));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Сумма всех элементов массива равна " + Converter.convectrInt(errorCharArray));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
