import java.util.*;

public class Pract1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        long a = 0, b = 1;
        int steps = 0;

        System.out.print("Fibonacci series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
            steps++;
        }

        System.out.println("\nStep count: " + steps);
        sc.close();
    }
}
