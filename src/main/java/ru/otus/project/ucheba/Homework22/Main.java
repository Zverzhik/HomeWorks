package ru.otus.project.ucheba.Homework22;

import java.util.Arrays;
import org.jetbrains.annotations.Contract;

public class Main {
    public static Integer [] removeLeftPartFromOne(Integer[] array) {
        int index = getIndexWithCondition(array, 1);
        if (index == -1) {
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(array, index + 1, array.length);
    }

    @Contract(pure = true)
    public static boolean isContainOnlyOneAndTwo(Integer [] array) {
        if (array.length == 0) {
            return false;
        }
        boolean isExistOne = false;
        boolean isExistTwo = false;
        for (Integer item : array) {
            switch (item) {
                case 1: isExistOne = true;
                    break;
                case 2: isExistTwo = true;
                    break;
                default: return false;
            }
        }
        return isExistOne && isExistTwo;
    }

    private static int getIndexWithCondition(Integer [] array, int condition) {
        int index = -1;
        for (int i = array.length; i-- > 0;) {
            if (array[i] == condition) {
                index = i;
                break;
            }
        }
        return index;
    }
}
