package ru.otus.project.ucheba.Homework20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static ru.otus.project.ucheba.Homework20.UTF_8.isFileExist;
import static ru.otus.project.ucheba.Homework20.UTF_8.requestFileName;

public class Main {
    public static void main(String[] args) {
        String charSequence;
        Scanner scanner = new Scanner(System.in);
        String path = "src/main";
        File file = requestFileName(path);
        System.out.println("Введите последовательность символов:");
        charSequence = scanner.nextLine();
        int occurrences = readFileAndCountOccurrences(file, charSequence);
        System.out.printf("Количество вхождений последовательности символов '%s' в файл %s равно %d%n", charSequence, file, occurrences);

    }
    public static int readFileAndCountOccurrences(File file, String charSequence) {
        int count = 0;
        if (!isFileExist(file)) {
            System.out.printf("Файл '%s' не существует!", file);
            return 0;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    count += countOccurrences(line, charSequence);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int countOccurrences(String line, String charSequence) {
        int count = 0;
        int position = 0;
        while ((position = line.indexOf(charSequence, position)) != -1) {
            count++;
            position++;
        }
        return count;
    }
}
