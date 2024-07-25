package ru.otus.project.ucheba.Homework8;

public class сonvertToInt {
    public static int convectrInt(String[][] array) throws AppArraySizeException, AppArrayDataException {
        int sum = 0;
        if (array.length != 4) throw new AppArraySizeException("Размерность массива должна быть 4x4");
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new AppArraySizeException("Размерность массива должна быть 4x4");
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j);
                    }
                }
            }
        return sum;
        }
    }
