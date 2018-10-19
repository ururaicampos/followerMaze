package com.challenge.soundcloud;

import com.challenge.soundcloud.Event.Event;
import com.challenge.soundcloud.Server.Server;
import com.challenge.soundcloud.Server.ServerAbstract;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class FollowerMaze {

    private static final int CLIENT_PORT = 9099;
    private static final int EVENT_PORT = 9090;
    private static final int SERVER_TIMEOUT = 500;

    private final ExecutorService executorService;
    private final List<ServerAbstract> serverAbstractList;

    public FollowerMaze(ExecutorService executorService, List<ServerAbstract> serverAbstractList) {
        this.executorService = executorService;
        this.serverAbstractList = serverAbstractList;
    }

    public void startServers(){
        for (ServerAbstract serverAbstract: serverAbstractList ){
            executorService.execute(serverAbstract);
        }
    }

    public static void main(String[] args) throws IOException {
        final Map<Integer, Client> clientMap = new ConcurrentHashMap<>();

        final PriorityBlockingQueue<Event> events =  new PriorityBlockingQueue<>();
        final PriorityBlockingQueue<Event> eventPriorityOrder = new PriorityBlockingQueue<>();

        final ServerSocket clientServer = new ServerSocket(CLIENT_PORT);
        clientServer.setSoTimeout(SERVER_TIMEOUT);

        final ServerSocket eventServer = new ServerSocket(EVENT_PORT);
        eventServer.setSoTimeout(SERVER_TIMEOUT);

        // Executors.newChachedThreadPool() -> Creates a Thread pool as needed and use previously constructed threads when available
        // final Server client = new Server(clientServer, Executors.newCachedThreadPool(), )

    }
}
