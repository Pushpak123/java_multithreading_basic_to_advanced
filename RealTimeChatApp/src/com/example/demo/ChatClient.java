package com.example.demo;

import javax.sound.sampled.Port;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {

            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connected to chat server");

            new Thread(() -> {
                String message;
                try {
                    while ((message = br.readLine()) != null) {
                        System.out.println("Received:" + message);
                    }
                } catch (IOException e) {
                    System.out.println("Connection error." + e.getMessage());
                }
            }).start();

            String userINput;
            while ((userINput = console.readLine()) != null) {
                pw.println(userINput);
            }


        } catch (IOException e) {
            System.out.println("Client error:" + e.getMessage());
        }
    }
}
