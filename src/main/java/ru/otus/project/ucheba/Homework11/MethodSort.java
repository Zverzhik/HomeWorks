package ru.otus.project.ucheba.Homework11;

public class MethodSort {
    public static void main(String[] args) {
        int[] bubble = new int[] {12, 23, 6, 234, -12};
        printArray(bubble);
        bubbleSort(bubble);
        printArray(bubble);

        int[] quick = new int[] {0, 322, 12, -3, 55};
        printArray(quick);
        quickSort(quick,0, quick.length-1);
        printArray(quick);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
    }

    private static void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (array.length == 0 || leftIndex >= rightIndex)
            return;

        int pivot = array[(leftIndex + rightIndex) / 2];
        int leftIndexCurrent = leftIndex;
        int rightIndexCurrent = rightIndex;

        while (leftIndexCurrent <= rightIndexCurrent) {
            while (array[leftIndexCurrent] < pivot) leftIndexCurrent++;
            while (array[rightIndexCurrent] > pivot) rightIndexCurrent--;
            if (leftIndexCurrent <= rightIndexCurrent) {
                int replace = array[leftIndexCurrent];
                array[leftIndexCurrent] = array[rightIndexCurrent];
                array[rightIndexCurrent] = replace;
                leftIndexCurrent++;
                rightIndexCurrent--;
            }
        }
        if (leftIndex < rightIndexCurrent) quickSort(array, leftIndex, rightIndexCurrent);
        if (rightIndex > leftIndexCurrent) quickSort(array, leftIndexCurrent, rightIndex);
    }
}
