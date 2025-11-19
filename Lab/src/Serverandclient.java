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

       

//Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("Hello Server");
        System.out.println("Server: " + in.readLine());
        s.close();
    }
}
