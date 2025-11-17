class Car {
    String model, color;
    Car(String m, String c) { model = m; color = c; }
    void start() { System.out.println("Car started"); }
    void stop() { System.out.println("Car stopped"); }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car("Tesla","Red");
        c.start();
        c.stop();
    }
}
