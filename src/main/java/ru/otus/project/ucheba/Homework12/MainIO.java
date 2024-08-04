package ru.otus.project.ucheba.Homework12;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MainIO {
    public static void main(String[] args) {
        File file;
        final String PATH = "src";

        getFiles(PATH);
        System.out.println();

        file = requestFile(PATH);
        readingFile(file);
        System.out.println();

        System.out.println();
        writeNewFile(file);

        System.out.println();
        readingFile(file);
    }

    public static void getFiles(String path) {
        File files = new File(path);
        System.out.println("Список текстовых файлов из корневого каталога проекта: ");
        File[] fileList = files.listFiles();
        for (File file : fileList) {
            if (file.isFile()) {
                    System.out.println(file.getName());
            }
        }
    }

    public static File requestFile(String path) {
        if (path == null) {
            return null;
        }
        File file;
        Scanner scanner = new Scanner(System.in);
        File dir = getFilePath(path);
        if (dir == null) {
            return null;
        }
        do {
            System.out.print("Введите имя файла: ");
            file = new File(dir, scanner.next());
            scanner.close();
        } while (!isFileExist(file));
        return file;
    }

    public static void readingFile(File file) {
        if (!isFileExist(file)) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeNewFile(File file) {
        if (!isFileExist(file)) {
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст для записи в файл: ");
        String text = scanner.nextLine();
        scanner.close();
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file, true))) {
            byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getFilePath(String rootPath) {
        if (rootPath == null || rootPath.isEmpty()) {
            return null;
        }
        return new File(rootPath).getAbsoluteFile();
    }

    public static boolean isFileExist(File file) {
        return file.exists();
    }
}
