// LC518_CoinChange2.java
import java.util.Arrays;

public class Main {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,5})); // 4
        System.out.println(change(3, new int[]{2}));     // 0
    }
}
