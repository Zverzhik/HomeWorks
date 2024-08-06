package ru.otus.project.ucheba.Homework13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        processCalculation();
        exitFromServer();
    }

    private static ServerSocket serverSocket;
    private static Socket client;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void processCalculation() throws IOException {
        serverSocket = new ServerSocket(8989);
        try {
            while (!serverSocket.isClosed()) {
                client = serverSocket.accept();
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
                out.writeUTF("Операции калькулятора: +, -, *, /");
                out.flush();
                while (true) {
                    String userInput = in.readUTF();
                    if (userInput.equals("stop")) {
                        exitFromServer();
                        break;
                    }
                    String[] clientRequest = userInput.split("\\s");
                    if (clientRequest.length != 3) {
                        out.writeUTF("Некорректно введена строка!\n" + "Введите две переменные и вычислительную операцию через пробел!\n" + "Введите снова правильно");
                        out.flush();
                        continue;
                    }
                    if (!clientRequest[0].matches("[-0-9]+") || !clientRequest[2].matches("[-0-9]+")) {
                        out.writeUTF("Переменные должны быть цифрами!\n" + "Введите снова правильно");
                        out.flush();
                        continue;
                    }
                    if (!clientRequest[1].matches("[-+*/]")) {
                        out.writeUTF("Вычислительная операция должны быть только символами \"-+*/\"\n" + "Введите снова правильно");
                        out.flush();
                        continue;
                    }
                    int int1 = Integer.parseInt(clientRequest[0]);
                    int int2 = Integer.parseInt(clientRequest[2]);
                    String operation = clientRequest[1];
                    switch (operation) {
                        case "+": {
                            out.writeUTF(String.valueOf(int1 + int2));
                            out.flush();
                            break;
                        }
                        case "-": {
                            out.writeUTF(String.valueOf(int1 - int2));
                            out.flush();
                            break;
                        }
                        case "*": {
                            out.writeUTF(String.valueOf(int1 * int2));
                            out.flush();
                            break;
                        }
                        case "/": {
                            try {
                                out.writeUTF(String.valueOf(int1 / int2));
                            } catch (ArithmeticException e) {
                                out.writeUTF("На ноль делить нельзя!\n" + "Попробуйте снова");
                                out.flush();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
    public static void exitFromServer() throws IOException {
        in.close();
        out.close();
        client.close();
        serverSocket.close();
    }
}