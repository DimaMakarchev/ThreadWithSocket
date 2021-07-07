import socket.br.com.SocketBr;

import java.io.*;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) throws IOException {

        try (final SocketBr socketBr = new SocketBr(new Socket("127.0.0.1", 8000))) {

            System.out.println("Connect with server");

            socketBr.writeOnly(" Hello bro");
            socketBr.readerGet();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
