import java.util.*;
public class FibRec {
    static int fib(int n) {
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = s.nextInt();
        for(int i = 0; i <= n; i++) System.out.print(fib(i) + " ");
    }
}
