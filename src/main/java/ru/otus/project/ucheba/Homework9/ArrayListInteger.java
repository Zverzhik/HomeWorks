package ru.otus.project.ucheba.Homework9;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListInteger {
    public static void main(String[] args) {
        List<Integer> arrayList;
        arrayList = arrayListMinMax(-1,10);
        System.out.println(arrayList);

        List<Integer> array1 = new ArrayList<>(Arrays.asList(2, -5, 5, 10, 21, 6));
        System.out.println(sumElements(array1));

        List<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, -5, 3, 13));
        rewriteEachFilledElement(4,array2);
        System.out.println(array2);

        List<Integer> array3 = new ArrayList<>(Arrays.asList(2, 4, -10, -2, 3));
        sumEachElementWithNumber(2,array3);
        System.out.println(array3);

    }
    public static List<Integer> arrayListMinMax(int min, int max) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            arrayList.add(i);
        }
        return arrayList;
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
    }
    public static void sumEachElementWithNumber (int number, List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != null) {
                array.set(i, array.get(i) + number);
            }
        }
    }
}
