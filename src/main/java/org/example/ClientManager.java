package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClientManager {
    private static ClientManager INSTANCE;
    List<ClientHandler> clientList = new ArrayList<ClientHandler>();


    private ClientManager() {
    }

    public static ClientManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ClientManager();
        }

        return INSTANCE;
    }

    void addClient(ClientHandler client) {
        this.clientList.add(client);
    }

    void removeClient(ClientHandler client){
        this.clientList.remove(client);
        System.out.println("client connected : " + this.clientList.size());
    }

}
