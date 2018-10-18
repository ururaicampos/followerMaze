package com.challenge.soundcloud.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main (String[] args) throws IOException{
        if(args.length<1) {}
    }

    private ServerSocket serverSocket;
    private Socket clientSocket;

    {
        try {
            //The event source connects on port 9090
            serverSocket = new ServerSocket(9090);

            //Waiting for client request
            clientSocket = serverSocket.accept();

            //Creating an output/input
            new PrintWriter(clientSocket.getOutputStream(), true);
            new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
