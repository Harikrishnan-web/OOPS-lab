public class Divide {
    static void test(int a, int b) {
        try {
            System.out.println(a + " / " + b + " = " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println(a + " / " + b + " = Exception handled");
        }
    }

    public static void exceptionhandling(String[] args) {
        test(10,2);
        test(20,0);
        test(-5,5);
        test(0,3);
        test(100,-10);
    }
}
