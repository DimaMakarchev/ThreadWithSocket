package socket.br.com;

import java.io.*;
import java.net.Socket;

public class SocketBr implements Closeable {

    private final Socket socket;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public SocketBr(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = reader();
        this.writer = writer();
    }


    private BufferedReader reader() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private BufferedWriter writer() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void writeOnly(String data) throws IOException {
        writer.write(data);
        writer.newLine();
        writer.flush();
    }

    public void close() throws IOException {
        socket.close();
        reader.close();
        writer.close();
    }

    public String readerGet() throws IOException {
        final String readerGet = reader.readLine();
        System.out.println("Read : " + readerGet);
        return readerGet;
    }
}
