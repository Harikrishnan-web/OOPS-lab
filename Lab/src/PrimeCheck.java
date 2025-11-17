import java.util.*;
public class PrimeCheck {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = s.nextInt();
        if(n <= 1) {
            System.out.println("Not Prime");
            return;
        }
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                System.out.println("Not Prime");
                return;
            }
        }
        System.out.println("Prime");
    }
}
