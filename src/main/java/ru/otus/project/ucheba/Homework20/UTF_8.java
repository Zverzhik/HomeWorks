package ru.otus.project.ucheba.Homework20;

import ru.otus.project.ucheba.Lesson16.ExampleServerCalculation.S;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UTF_8 {
    public static File getFileAbsolutePath(String rootPath) {
        if (rootPath == null) {
            return null;
        }
        return new File(rootPath).getAbsoluteFile();
    }

    public static List<String> getListFile(String rootPath) {
        if (rootPath == null) {
            return new ArrayList<>(0);
        }
        File[] folderContent = getFileAbsolutePath(rootPath).listFiles();
        List<String> list = new ArrayList<>();
        if (folderContent != null) {
            for (File file : Objects.requireNonNull(folderContent)) {
                if (file.isDirectory()) {
                    list.add(file.getName());
                }
            }
        }
        return list;
    }

    public static File requestFileName(String path) {
        if (path == null) {
            return null;
        }
        File file;
        Scanner scanner = new Scanner(System.in);
        File rootDirectory = getFileAbsolutePath(path);
        if (rootDirectory == null) {
            return null;
        }
        do {
            System.out.println("Введите имя файла:");
            file = new File(rootDirectory, scanner.next());
        } while (!isFileExist(file));
        return file;
    }

    public static void readingFile(File file) {
        if (!isFileExist(file)) {
            return;
        }
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            do {
                String line = bufferedReader.readLine();
                System.out.println(line);
            } while (bufferedReader.ready());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writingFile(File file) {
        if (!isFileExist(file)) {
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст, который запишется в файл:");
        String text = scanner.next();
        try (FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isFileExist(File file) {
        return file.exists();
    }
}
