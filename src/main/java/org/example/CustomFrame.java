package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class CustomFrame extends JFrame {
    private String address;

    private String port;
    private JTextArea responseArea;

    public CustomFrame(String address,String port) {
        this.port = port;
        this.address = address;
        setTitle("Simple HTTP Client");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        JComboBox<String> comboBox;
        String[] values = {"for_man", "for_woman", "sorted_by_name", "sorted_by_price"};
        comboBox = new JComboBox<>(values);

        // Create the JLabel to display the selected value

        // Add an ActionListener to the JComboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = "http://"+address+":"+port+"/$cmd=" + (String) comboBox.getSelectedItem();
                String result = synchronous(selectedValue);
                System.out.println(selectedValue);
                responseArea.setText(result);
            }
        });

        inputPanel.add(comboBox, BorderLayout.CENTER);


        mainPanel.add(inputPanel, BorderLayout.NORTH);

        responseArea = new JTextArea();
        responseArea.setEditable(false);
        mainPanel.add(new JScrollPane(responseArea), BorderLayout.CENTER);

        add(mainPanel);
    }

    public static String synchronous(String uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
        return response.body();
    }

}