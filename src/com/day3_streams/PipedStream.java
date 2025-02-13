package com.day3_streams;
import java.io.*;

//  Writing data to PipedOutputStream
class WriterThread extends Thread {
    //attributes
    private PipedOutputStream pos;

    //constructor
    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            // Writing data to the pipe
            pos.write(message.getBytes());
            // Closing the stream after writing
            pos.close();
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
}

// Reading PipedInputStream
class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        //Using try catch block to exception handling
        try {
            byte[] buffer = new byte[1024];
            // Reading data from the pipe
            int bytesRead = pis.read(buffer);
            System.out.println("Received: " + new String(buffer, 0, bytesRead));
            pis.close();
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}

public class PipedStream {
    public static void main(String[] args) {
        try {

            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

        } catch (IOException e) {
            System.out.println("Error setting up piped streams: " + e.getMessage());
        }
    }
}
