public class Solution {
    public int totalNQueens(int n) {
        boolean[] usedCol = new boolean[n];
        boolean[] diag1 = new boolean[2*n];
        boolean[] diag2 = new boolean[2*n];
        return dfs(0, n, usedCol, diag1, diag2);
    }

    private int dfs(int r, int n, boolean[] usedCol, boolean[] d1, boolean[] d2) {
        if (r == n) return 1;
        int count = 0;
        for (int c = 0; c < n; c++) {
            int i1 = r + c, i2 = r - c + n;
            if (usedCol[c] || d1[i1] || d2[i2]) continue;
            usedCol[c] = d1[i1] = d2[i2] = true;
            count += dfs(r + 1, n, usedCol, d1, d2);
            usedCol[c] = d1[i1] = d2[i2] = false;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(4)); // 2
    }
}
