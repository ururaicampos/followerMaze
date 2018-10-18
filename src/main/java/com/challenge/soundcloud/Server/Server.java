package com.challenge.soundcloud.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
    Challenge Observations:
        - Build a socket server, reading events from event source. Clients connect through TCP.
        - Two type of client connections:
            -One (event source): Send a stream of events which may or may not require clients to be notified.
            -Many (user clients): Each one representing a user, wait for notifications for relevant events to the user they represent
    PROTOCOL:
        - All strings are encoded in UTF-8. Event Souce at port 9090; Many user clients at 9099;
        - One: Send events as soon the connection is accepted. Events should be sent to relevant user clients exactly like read, no modification allowed.
        - Many: When connection is accepted, they will send to the server the ID of the represented user. Example: 2932\r\n
            ... -> user 2932. After the ID is sent, the user client starts waiting for events to be send to them.
    EVENTS:
        -> Payload - Sequence # - Type - From User ID - To User ID
         .  666 .   F   .   60  .   50  .   666 .
         .  1   .   U   .   12  .   9   .   1   .
         .542532.   B   .542532 . Broadcast. -  .
         .  43  .   P   .   32  .   56  .   43  .
         .  634 .   S   .   32  .   634 .   Status Update   .

 */
public class Server {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        int portNumber = Integer.parseInt(args[0]);
        ExecutorService executor = null;
        try (ServerSocket serverSocket = new ServerSocket(9090);) {

            //Create Thread to process client request - 5 fixed pool
            Executors.newFixedThreadPool(5);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Runnable worker = new RequestHandler(clientSocket);
                executor.execute(worker);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection" );
        } finally {
            if (executor != null){
                executor.shutdown();
            }
        }

    }
}