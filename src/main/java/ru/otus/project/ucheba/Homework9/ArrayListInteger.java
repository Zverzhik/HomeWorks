package ru.otus.project.ucheba.Homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListInteger {
    public static void main(String[] args) {
        ArrayListMinMax(-1,10);

        List<Integer> array = new ArrayList<>(Arrays.asList(2, -5, 5, 10, 21, 6));
        System.out.println(sumElements(array));

        rewriteEachFilledElement(4,Arrays.asList(1, 2, -5, 3, 13));

        sumEachElementWithNumber(2,Arrays.asList(2, 4, -10, -2, 3));

    }
    public static void ArrayListMinMax (int min, int max) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
    }
    public static int sumElements (List<Integer> array) {
        int sum = 0;
        for (Integer elem : array) {
            if (elem > 5) {
                sum += elem;
            }
        }
        return sum;
    }
    public static void rewriteEachFilledElement (int number, List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != null) {
                array.set(i,number);
            }
        }
        System.out.println(array);
    }
    public static void sumEachElementWithNumber (int number, List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != null) {
                array.set(i, array.get(i) + number);
            }
        }
        System.out.println(array);
    }
}
