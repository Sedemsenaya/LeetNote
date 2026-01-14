public class Solution {
    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        return dfs(1, n, used);
    }

    private int dfs(int pos, int n, boolean[] used) {
        if (pos > n) return 1;
        int count = 0;
        for (int x = 1; x <= n; x++) {
            if (used[x]) continue;
            if (x % pos != 0 && pos % x != 0) continue;
            used[x] = true;
            count += dfs(pos + 1, n, used);
            used[x] = false;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countArrangement(3)); // 3
    }
}
