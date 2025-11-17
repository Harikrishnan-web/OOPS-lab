//Interface
import java.rmi.*;

public interface Service extends Remote {
    String send(String msg) throws RemoteException;
}
//Implementation
import java.rmi.*;
import java.rmi.server.*;

public class Server extends UnicastRemoteObject implements Service {
    Server() throws RemoteException { super(); }

    public String send(String msg) throws RemoteException {
        return "Server received: " + msg + " on " + Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            Naming.rebind("service", new Server());
            System.out.println("Server ready");
        } catch(Exception e) { System.out.println(e); }
    }
}
//Client
import java.rmi.*;

public class Client {
    public static void main(String[] args) {
        try {
            Service s = (Service) Naming.lookup("rmi://localhost/service");
            System.out.println(s.send("Hello"));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
