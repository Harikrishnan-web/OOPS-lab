// server
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 9000;
        
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server waiting on port " + port);
        
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");
        
        InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader reader = new BufferedReader(isr);
        
        String message = reader.readLine();
        System.out.println("Received: " + message);
        
        reader.close();
        isr.close();
        clientSocket.close();
        serverSocket.close();
    }
}

// client      

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int port = 9000;

        Socket socket = new Socket(serverIP, port);
        System.out.println("Connected. Sending message...");
        
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        
        writer.println("Hello from the minimalist Java client!");
        
        writer.close();
        socket.close();
    }
}
