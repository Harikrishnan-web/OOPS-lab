class BaseShape {
    double area() { return 0; }
}

class Circle extends BaseShape {
    double r;
    Circle(double r) { this.r = r; }
    double area() { return 3.14 * r * r; }
}

class Rectangle extends BaseShape {
    double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    double area() { return w * h; }
}

public class Shape {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        Rectangle r = new Rectangle(10,5);
        BaseShape s = new BaseShape();
        System.out.println(c.area());
        System.out.println(r.area());
        System.out.println(s.area());
    }
}
