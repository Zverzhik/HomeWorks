package ru.otus.project.ucheba.Lesson6;

public class TicToe {

    static char[][] gameField = new char[3][3];

    public static void main(String[] args) {
        for (int i = 0; i < gameField.length; i++) { //чтобы поле было играбельным, сделали его пустым, те присвоили вместо окошек, ' '.
            for (int j = 0; j < gameField.length; j++) {
                gameField[i][j] = ' ';
            }
        }
        printField();
    }

    private static void printField() { //создали поле
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
    }
}
