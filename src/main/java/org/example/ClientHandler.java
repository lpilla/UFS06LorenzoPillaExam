package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.InetAddress;
import java.net.Socket;


public class ClientHandler extends Thread{

    private Socket clientSocket;
    private PrintWriter out = null; // allocate to write answer to client.

    private ShoeManager shoeManager;
    String answer;


    public ClientHandler(Socket clientSocket, ShoeManager shoeManager){
        this.clientSocket = clientSocket;
        this.shoeManager = shoeManager;
        InetAddress inetAddress = this.clientSocket.getInetAddress();
        System.out.println("Connected from: " + inetAddress);
    }

    boolean manage(){

        BufferedReader in;

        try {
            in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            return false;
        }




        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        String s = "";
        Command cmd = null;
        Gson g = new Gson();

        while(true) {
            try {
                if ((s = in.readLine()) == null) {
                    break;
                }
            } catch (IOException e) {
                return false;
            }
            try {
                cmd = new Command().fromMethod(s);
            } catch (Exception e) {
                out.flush();
                out.println(new Answer(false, "Serve un JSON").answerJSON());
                continue;
            }


            if (cmd != null && cmd.cmd.equals("for_man")) {
                answer = new Answer(true, shoeManager.getManShoes()).answerJSON();
            } else if (cmd != null && cmd.cmd.equals("for_woman")) {
                answer = new Answer(true, shoeManager.getWomanShoes()).answerJSON();
            } else if (cmd != null && cmd.cmd.equals("sorted_by_name")) {
                answer = new Answer(true, shoeManager.sortedByName()).answerJSON();
            }else if (cmd != null && cmd.cmd.equals("sorted_by_price")) {
                answer = new Answer(true, shoeManager.sortedByPrice()).answerJSON();
            } else {
                answer = new Answer(false, "Comando sconosciuto").answerJSON();
            }
            out.flush();
            out.println(answer);
        }
        return true;
    }

    @Override
    public void run() {
        manage();

        ClientManager.getInstance().removeClient(this);
    }


}
