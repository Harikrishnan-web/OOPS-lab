class Racer extends Thread {
    String name;
    int delay;
    Racer(String n, int d) { name = n; delay = d; }

    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(name + " step " + i);
            try { Thread.sleep(delay); } catch(Exception e) {}
        }
        System.out.println(name + " finished!");
    }
}

public class Race {
    public static void main(String[] args) {
        Racer a = new Racer("A", 300);
        Racer b = new Racer("B", 500);
        Racer c = new Racer("C", 300);
        a.start();
        b.start();
        c.start();
    }
}
