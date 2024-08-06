package ru.otus.project.ucheba.Homework13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        clientProcess();
        exitFromClient();
    }

    private static DataInputStream in;
    private static DataOutputStream out;
    private static Socket socket;

    public static void clientProcess() {
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket("localhost",8989);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println(in.readUTF());
            System.out.println("Для выхода введите: stop\n" + "Выражение должно выглядеть следующим образом: 2 * 4\n" + "Введите выражение:");
            while (true) {
                String userInput = scanner.nextLine();
                if (userInput.equals("stop")) {
                    break;
                }
                out.writeUTF(userInput);
                out.flush();
                String answer = in.readUTF();
                System.out.println("Результат: " + answer);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exitFromClient() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
