package com.challenge.soundcloud.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Servidor extends ServerAbstract {

    // ServerSocket -> Waits for requests to come over. It performs something, then possibly return a result to the requester.
    private ServerSocket serverSocket;

    // ExecutorService -> Subinterface of Executor. Tracking progress of one or more asynchronous tasks.
    ExecutorService executorService;

    // Initialize variables at the constructor
    Servidor(ServerSocket serverSocket, ExecutorService executor) {
        this.serverSocket = serverSocket;
        this.executorService = executor;
    }

    @Override
    public void run() {
        Socket socket;
        try {
            socket = serverSocket.accept(); // accept() -> Listen for a connection to this socket and accepts it.

            // execute() -> Execute at some time in the future. It may be a new thread, pooled thread ...
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
