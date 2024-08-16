package ru.otus.project.ucheba.Homework21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private final Object mon = new Object();
    private char currentLetter = 'A';

    public static void main(String[] args) {
        Main main = new Main();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <= 3; i++) {
            int index = i;
            executorService.execute(() -> {
                switch (index) {
                    case 1:
                        main.printLetter('A');
                        break;
                    case 2:
                        main.printLetter('B');
                        break;
                    case 3:
                        main.printLetter('C');
                        break;
                }
            });
        }
        executorService.shutdown();
    }

    public void printLetter(Character letter) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != letter) {
                        mon.wait();
                    }
                    System.out.print(letter);
                    currentLetter = changeLetter(letter);
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private char changeLetter(char letter) {
        switch (letter) {
            case 'A':
                return 'B';
            case 'B':
                return 'C';
            case 'C':
                return 'A';
            default:throw new IllegalArgumentException("Неожидаемое значение: " + letter);
        }
    }
}
