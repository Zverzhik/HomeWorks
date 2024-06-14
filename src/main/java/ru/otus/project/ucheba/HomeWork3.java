package ru.otus.project.ucheba;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {
        System.out.println(sumOfPositiveElements(new int[][]{{2, 4, -5, 1, 0}, {3, 19, 2, -2, -9, -4, 1}}));

        int[][] size = new int[3][3];
        squarePrint(size);

        char[][] arr = new char[5][5];
        twoDimentionalArray(arr, '_');

        int[][] array = new int[][]{{2, -9, 10}, {0, -1, 4, 11}};
        System.out.println(fingMax(array));

        System.out.println(sumSecondHeight(new int[][]{{1, 2, 4}, {-1, 3, 2}}));
    }


    public static int sumOfPositiveElements(int[][] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] > 0) {
                    sum += input[i][j];
                }
            }
        }
        return sum;
    }


    public static void squarePrint(int[][] size) {
        for (int i = 0; i < size.length; i++) {
            for (int j = 0; j < size[i].length; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }


    public static void twoDimentionalArray(char[][] in, char value) {
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                in[i][j] = value;
            }
        }
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                if (i == j) {
                    in[i][j] = 'O';
                }
                System.out.print(in[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int fingMax(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public static int sumSecondHeight(int[][] input) {
        if (input.length < 2) {
            return -1;
        }
        int sum = 0;
            for (int j = 0; j < input[1].length; j++) {
                    sum += input[1][j];
            }
        return sum;
    }
}

