import java.util.*;

public class Solution {
    public boolean makesquare(int[] matchsticks) {
        long sum = 0;
        for (int x : matchsticks) sum += x;
        if (sum % 4 != 0) return false;
        int side = (int)(sum / 4);

        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int t = matchsticks[i]; matchsticks[i] = matchsticks[j]; matchsticks[j] = t;
        }

        int[] bucket = new int[4];
        return dfs(matchsticks, 0, bucket, side);
    }

    private boolean dfs(int[] a, int idx, int[] bucket, int side) {
        if (idx == a.length) {
            return bucket[0] == side && bucket[1] == side && bucket[2] == side && bucket[3] == side;
        }
        int val = a[idx];
        for (int i = 0; i < 4; i++) {
            if (bucket[i] + val > side) continue;
            bucket[i] += val;
            if (dfs(a, idx + 1, bucket, side)) return true;
            bucket[i] -= val;
            if (bucket[i] == 0) break; // symmetry prune
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().makesquare(new int[]{1,1,2,2,2})); // true
    }
}
