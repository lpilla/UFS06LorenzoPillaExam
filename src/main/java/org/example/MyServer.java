package org.example;


import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer
{
    static ShoeManager shoeManager = new ShoeManager();

    static int portNumber = 1234;
    static ServerSocket serverSocket;

    static boolean startServer(){
        try{
            serverSocket = new ServerSocket(portNumber);
            return true;
        }catch (Exception e){
            return false;
        }

    }


    public static void main( String[] args )
    {
        if(!startServer()){
            return;
        }

        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.createContext("/", new MyHandler(shoeManager));
        server.setExecutor(null); // creates a default executor
        server.start();

        while (true){

            Socket clientSocket;
            try{
                clientSocket = serverSocket.accept();
            } catch(IOException e){
                throw new RuntimeException(e);
            }

            ClientHandler clientHandler = new ClientHandler(clientSocket,shoeManager);
            ClientManager.getInstance().addClient(clientHandler);
            clientHandler.start();
        }
    }

}