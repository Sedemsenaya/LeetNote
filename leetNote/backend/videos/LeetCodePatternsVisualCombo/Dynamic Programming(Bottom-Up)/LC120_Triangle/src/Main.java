// LC120_Triangle.java
import java.util.List;
import java.util.Arrays;

public class Main {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        // start from bottom row
        for (int j = 0; j < n; j++) dp[j] = triangle.get(n-1).get(j);
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> tri = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)
        );
        System.out.println(minimumTotal(tri)); // 11
    }
}
