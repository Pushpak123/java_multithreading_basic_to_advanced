package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket clientSocket;
    private PrintWriter pw;

    public ClientHandler(Socket clientSocket)
    {
        this.clientSocket=clientSocket;
    }

    @Override
    public void run() {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            pw=new PrintWriter(clientSocket.getOutputStream());
            String message;
            while((message= br.readLine())!=null)
            {
                System.out.println("Received Message: "+message);
                ChatServer.broadcast(message,this);
            }
        } catch (IOException e) {
            System.out.println("Client error:"+e.getMessage());
        }finally {
            ChatServer.removeClient(this);
            try{
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Failed to closed client socket:"+e.getMessage());
            }
        }
    }
    public void sendMessage(String message)
    {
       if(pw!=null)
       {
           pw.println(message);
       }
    }
}
