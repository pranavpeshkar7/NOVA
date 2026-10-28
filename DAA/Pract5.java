import java.util.*;

public class Pract5 {
    static int binomial(int n, int k) {
        int[][] C = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i)
                    C[i][j] = 1;
                else
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
        return C[n][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n and k: ");
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println("C(n,k) = " + binomial(n, k));
        sc.close();
    }
}
