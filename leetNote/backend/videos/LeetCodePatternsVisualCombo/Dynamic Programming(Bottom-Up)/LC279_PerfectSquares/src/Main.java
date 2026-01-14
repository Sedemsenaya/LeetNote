// LC279_PerfectSquares.java
import java.util.Arrays;

public class Main {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 0;
        for (int i = 1; i*i <= n; i++) {
            int square = i*i;
            for (int s = square; s <= n; s++) {
                dp[s] = Math.min(dp[s], dp[s - square] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12)); // 3 (4+4+4)
        System.out.println(numSquares(13)); // 2 (4+9)
    }
}
