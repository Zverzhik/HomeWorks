package ru.otus.project.ucheba.Homework8;

public class AppArrayDataException extends Exception {
    public AppArrayDataException (int x, int y) {
        super(String.format("Массив имеет неверные данные в ячейке [%d, %d]\n", x, y));
    }
}
