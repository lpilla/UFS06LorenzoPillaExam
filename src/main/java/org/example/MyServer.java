package org.example;


import com.sun.net.httpserver.HttpServer;

import javax.swing.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
        if(args.length == 1 && args[0].equals("server")){
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
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
        }

    }
    private static void createAndShowGUI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Created GUI on EDT? " + SwingUtilities.isEventDispatchThread());
        System.out.println("insert IP Address of the host machine");
        String address = scanner.nextLine();
        System.out.println("insert PORT of the host machine");
        String port = scanner.nextLine();
        JFrame f = new CustomFrame(address,port);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(750, 750);
        f.setVisible(true);
    }

}