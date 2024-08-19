package ru.otus.project.ucheba;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FileManager implements Commands{
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String in;
        System.out.println("--Добро пожаловать в Консольный файловый менеджер--");
        System.out.println("Введите каталог:\n" +
                "Если поле пустое, то по умолчанию будет выбран установочный каталог приложения.");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (!(in = bufferedReader.readLine()).equals("") && !(in.equals("CONTINUE"))) {
                path = (in.equals("")) ? System.getProperty("user.dir") : in;
                System.out.println(path);
                File fileSystem = new File(path);
                if (fileSystem.exists()&&fileSystem.isDirectory()){
                    System.out.println("Если это ваш окончательный выбор каталога, введите CONTINUE:\n" +
                            "Если нет, введите другой каталог:");
                } else {
                    System.out.println("То, что вы ввели не является каталогом или не существует!\n" +
                            "Повторите попытку:");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (path.equals(System.getProperty("user.dir"))) {
            System.out.println("По умолчанию выбран корневой каталог приложения.");
        } else {
            System.out.println("Был выбран " + path + " в качестве корневого каталога.");
        }
        availableCommands();
        try{
            while (!(in=bufferedReader.readLine()).equals(Commands.EXIT)) {
                switch (in) {
                    case Commands.LIST_OF_FILES:
                        listOfFiles(path);
                        break;
                    case Commands.CHANGE_DIR:
                        changeDir(path);
                        break;
                    case Commands.CREATE_DIR:
                        System.out.println("Введите имя каталога: ");
                        String dirName = bufferedReader.readLine();
                        System.out.println("Вы можете добавить путь к новому каталогу или же нажать enter, чтобы создать его в текущем каталоге: " + path);
                        String dirPath = bufferedReader.readLine();
                        if (!dirPath.equals("")) {
                            createDir(dirName, dirPath);
                        }else {
                            createDir(dirName, path);
                        }
                        break;
                    case Commands.REMOVE:
                        System.out.println("Введите файл или каталог, чтобы удалить:");
                        String fileName = bufferedReader.readLine();
                        delete(fileName, path);
                        break;
                    case Commands.RENAME:
                        System.out.println("Введите имя файла или каталога, которое хотите изменить:");
                        fileName = bufferedReader.readLine();
                        System.out.println("Введите новое имя для файла или каталога:");
                        String newFileName = bufferedReader.readLine();
                        renameFile(fileName, newFileName, path);
                        break;
                    case Commands.COPY_FILE:
                        System.out.println("Введите файл, который хотите скопировать:");
                        fileName = bufferedReader.readLine();
                        System.out.println("Введите каталог, куда хотите скопировать файл:");
                        String newFilePath = bufferedReader.readLine();
                        try {
                            copyFile(fileName, newFilePath, path);
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        break;
                    case Commands.INFO_FILE:
                        System.out.println("Введите файл, о котором хотите узнать информацию:");
                        String filePath = bufferedReader.readLine();
                        detailedInfo(filePath, path);
                        break;
                    case Commands.OUTPUT_OF_COMMANDS:
                        availableCommands();
                        break;
                    default:
                        System.out.println("Такой команды нет!");
                        availableCommands();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void availableCommands() {
        System.out.println("Вы можете выбрать следующие команды:");
        System.out.println("      - ls: распечатать список файлов текущего каталога с информацией о файле (имя, размер, дата последнего изменения)");
        System.out.println("      - cd: переход в указанную поддиректорию");
        System.out.println("      - mkdir: создание новой директории с указанным именем");
        System.out.println("      - rm: удаление указанного файла или директории");
        System.out.println("      - mv: переименовать/перенести файл или директорию");
        System.out.println("      - cp: скопировать файл");
        System.out.println("      - finfo: получить подробную информацию о файле");
        System.out.println("      - help: вывод в консоль всех поддерживаемых команд");
        System.out.println("      - exit: завершить работу");
    }

    private static void listOfFiles(String path) {
        File rootDirectory = new File(path);
        File[] files = rootDirectory.listFiles();
        for (File file : files){
            if (file.isFile()) {
                infoFile(file);
            }
        }
    }

    private static void infoFile(File file) {
        if (file.exists()){
            System.out.println("Имя файла: " + file.getName());
            System.out.println("Размер файла: " + file.length());
            System.out.println("Дата последнего изменения: " + getLastModifiedDate(file));
        }
    }

    private static String getLastModifiedDate(File file) {
        Instant instant = Instant.ofEpochMilli(file.lastModified());
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTime.format(dateTimeFormatter);
    }

    private static void changeDir(String path) throws IOException {
        File file;
        file = new File(path);
        System.out.println(file.getCanonicalPath());
        file = new File(path + "/..");
        System.out.println(file.getCanonicalPath());
    }

    private static void createDir(String dirName, String dirPath) {
        dirPath = sanitizePath(dirPath);
        File newDir = new File(dirPath + dirName);
        if (!newDir.exists() || !newDir.isDirectory()) {
            newDir.mkdir();
            System.out.println("Создан новый каталог: " + newDir.getName() + " в: " + newDir.getPath());
        } else {
            System.out.println("Каталог уже существует!");
        }
    }

    private static void delete(String fileName, String path) {
        path = sanitizePath(path);
        File file = new File(path + fileName);
        if (file.exists()) {
            file.delete();
            System.out.println(fileName + " успешно удален.");
        } else {
            System.out.println("Нельзя удалить ' " + fileName + " ', такого файла не существует!");
        }
    }

    private static void renameFile(String fileName, String newFileName, String path) {
        path = sanitizePath(path);
        File oldFile = new File(path + fileName);
        File newFile = new File(path + newFileName);
        if (!oldFile.exists()){
            System.out.println("Нельзя переименовать! Такого файла не существует!");
            return;
        } else if (newFile.exists()){
            System.out.println("Нельзя переименовать! Такое имя файла уже существует!");
            return;
        } else if (oldFile.renameTo(newFile)){
            System.out.println("Файл успешно переименован.");
            return;
        } else {
            System.out.println("Не удалось переименовать файл!");
        }
    }

    private static void copyFile(String fileName, String newFilePath, String path) throws IOException{
        path = sanitizePath(path);
        newFilePath = sanitizePath(newFilePath);
        Path oldFile = Paths.get(path + fileName);
        Path newFile = Paths.get(path + newFilePath + fileName);
        if (!Files.exists(oldFile)) {
            System.out.println("Не удалось скопировать файл, так как его не существует!");
            return;
        } else if (Files.exists(newFile)) {
            System.out.println("Не удалось скопировать файл, так как уже есть файл с таким именем!");
            return;
        } else if (!(Files.isDirectory(newFile.getParent()))) {
            System.out.println("Не удалось скопировать файл, так как такого каталога не существует!");
            return;
        } else {
            Files.copy(oldFile, newFile);
            System.out.println("Файл успешно скопирован.");
            return;
        }
    }

    private static void detailedInfo(String fileName, String rootPath) {
        rootPath = sanitizePath(rootPath);
        File file = new File(rootPath + fileName);
        if (file.exists()) {
            System.out.println("Имя: " + file.getName());
            System.out.println("Тип: " + showType(file));
            System.out.println("Размер файла: " + file.length());
            System.out.println("Дата последнего изменения: " + getLastModifiedDate(file));
        }
    }

    private static String showType(File file) {
        if (file.isDirectory()) {
            return "Каталог";
        } else if (file.isFile()) {
            return "Файл";
        } else {
            return "Неизвестный";
        }
    }

    private static String sanitizePath(String path) {
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        return path;
    }
}
