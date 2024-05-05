package ru.otus.project.ucheba;

import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {
        zadacha1(4, "ABC");
        zadacha2(6, 4, 5, 6, 8, 2, 7);
        zadacha3(6,1, 4, 7, 8, 3, 4);
        zadacha4(2, 2, 3, 1, 2, 6, 9, 2);
        zadacha5(1, 2, 3, 4, 5, 6);
    }

    public static void zadacha1(int a, String str) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    public static void zadacha2(int...ar1) {
        int sum = 0;
        for (int i = 0; i < ar1.length; i++) {
            if (ar1[i] > 5) {
                sum += ar1[i];
            }
        }
        System.out.println(sum);
    }

    public static void zadacha3(int b, int...ar2) {
        for (int i = 0; i < ar2.length; i++) {
            ar2[i] = b;
        }
        System.out.println(Arrays.toString(ar2));
    }

    public static void zadacha4(int c, int...ar3) {
        for (int i = 0; i < ar3.length; i++) {
            ar3[i] += c;
        }
        System.out.println(Arrays.toString(ar3));
    }

    public static void zadacha5(int...ar4) {
        int sum1 = 0;
        for (int i = 0; i < ar4.length / 2; i++) {
            sum1 += ar4[i];
        }
        int sum2 = 0;
        for (int i = ar4.length / 2; i < ar4.length; i++) {
            sum2 += ar4[i];
        }
        if (sum1 > sum2) {
            System.out.println("Сумма элементов первой половины массива больше второй");
        } else if (sum1 < sum2) {
            System.out.println("Сумма элементов второй половины массива больше первой");
        } else {
            System.out.println("Суммы двух половин массива одинаковы");
        }
    }
}