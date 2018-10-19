package com.challenge.soundcloud;

import java.io.PrintWriter;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Client implements Comparable<Client> {

    private final Integer userId;
    private AtomicBoolean isConnected = new AtomicBoolean(false);
    private final Set<Client> clients;
    private PrintWriter writer;

    public Client(Integer userId, AtomicBoolean isConnected, Set<Client> clients, PrintWriter writer) {
        this.userId = userId;
        this.isConnected = isConnected;
        this.clients = clients;
        this.writer = writer;
    }

    public Integer getUserId() {
        return userId;
    }

    public void following(Client c) {
        clients.add(c);
    }

    public void unfollowing(Client c) {
        clients.remove(c);
    }

    public boolean notifySingleClient(String msg) {
        if (writer != null && isConnected.get()) {
            writer.println(msg);
            return writer.checkError();
        } else {
            return false;
        }
    }

    public void notifyAllClients(String msg) {
        for (Client client : clients) {
            client.notifySingleClient(msg);
        }
    }

    @Override
    public int compareTo(Client client) {
        return userId.compareTo(client.userId);
    }
}
