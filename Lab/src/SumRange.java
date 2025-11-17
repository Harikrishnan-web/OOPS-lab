import java.util.*;
public class SumRange {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter start: ");
        int a = s.nextInt();
        System.out.print("Enter end: ");
        int b = s.nextInt();
        int sum = 0;
        for(int i = a; i <= b; i++) sum += i;
        System.out.println(sum);
    }
}
