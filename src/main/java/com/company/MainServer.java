package com.company;

import socket.br.com.SocketBr;

import java.io.*;
import java.net.ServerSocket;

public class MainServer {

    public static void main(String[] args) throws IOException {
        // write your code here

        try (ServerSocket serverSocket = new ServerSocket(8000);) {
            while (true)
                try (SocketBr socketBr = new SocketBr(serverSocket.accept())) {
                    System.out.println("Server started");

                    final String get = socketBr.readerGet();
                    socketBr.writeOnly( "Answer : " + get);

                    System.out.println("Client connected");

                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
