// LC368_LargestDivisibleSubset.java
import java.util.*;

public class Main {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIdx]) maxIdx = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = maxIdx; i >= 0; i = prev[i]) {
            res.add(nums[i]);
            if (prev[i] == -1) break;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1,2,4,8}));
        System.out.println(largestDivisibleSubset(new int[]{1,3,6,24}));
    }
}
