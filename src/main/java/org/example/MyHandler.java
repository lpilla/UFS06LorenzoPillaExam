package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;

public class MyHandler implements HttpHandler {
    ShoeManager shoeManager;

    public MyHandler(ShoeManager shoeManager) {
        this.shoeManager = shoeManager;
    }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();

        URI uri = exchange.getRequestURI();

        String method = exchange.getRequestMethod();
        System.out.println(method);

        String s = read(is);
        System.out.println(s);


        String response;
        if (method.equals("POST")) {
            response = process(s);
        } else {
            response = process(uri.toString().substring(2));
        }
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private String process( String data){

        String[] splitted = data.split("&");
        if (splitted.length == 0)
            return "no data";
        else{
            String cmd = splitted[0].split("=")[0];
            String options = splitted[0].split("=")[1];

            if (cmd.equals("cmd") && options.equals("for_man")){
                return new Answer(true, shoeManager.getManShoes()).answerJSON();
            }
            if (cmd.equals("cmd") && options.equals("for_woman")){
                return new Answer(true, shoeManager.getWomanShoes()).answerJSON();

            }
            if (cmd.equals("cmd") && options.equals("sorted_by_name")){
                return new Answer(true, shoeManager.sortedByName()).answerJSON();
            }
            if (cmd.equals("cmd") && options.equals("sorted_by_price")){
                return new Answer(true, shoeManager.sortedByPrice()).answerJSON();
            }
            else {
                return new Answer(false, "bad request").answerJSON();
            }
        }
    }

    private String read(InputStream is) {
        BufferedReader br = new BufferedReader( new InputStreamReader(is) );
        System.out.println("\n");
        String received = "";
        while (true) {
            String s = "";
            try {
                if ((s = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(s);
            received += s;
        }
        return received;
    }
}
