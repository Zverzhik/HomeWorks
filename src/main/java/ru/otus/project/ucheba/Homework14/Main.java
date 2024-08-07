package ru.otus.project.ucheba.Homework14;

public class Main {
    public static void main(String[] args) {
        System.out.println("Реализация №1\n" + "Время выполнения:");
        firstRealization();
        System.out.println();
        System.out.println("Реализация №2\n" + "Время выполнения:");
        secondRealization();
    }
    private static void firstRealization() {
        long time = System.currentTimeMillis();
        calcArray1(100_000_000);
        System.out.println(System.currentTimeMillis() - time + " миллисекунд");
    }

    private static void secondRealization() {
        long time = System.currentTimeMillis();
        calcArray2(100_000_000);
        System.out.println(System.currentTimeMillis() - time + " миллисекунд");
    }

    private static double[] calcArray1(int numberOfElements) {
        double[] array = new double[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        return array;
    }

    private static double[] calcArray2(int numberOfElements) {
        double[] array = new double[numberOfElements];
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberOfElements / 4; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = numberOfElements / 4; i < numberOfElements / 2; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = numberOfElements / 2; i < numberOfElements * 3 / 4; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = numberOfElements * 3 / 4; i < numberOfElements; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        return array;
    }
}
