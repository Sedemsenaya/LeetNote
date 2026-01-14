import java.util.*;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] col = new int[n]; // col[row] = c
        Arrays.fill(col, -1);
        boolean[] usedCol = new boolean[n];
        boolean[] diag1 = new boolean[2*n]; // r+c
        boolean[] diag2 = new boolean[2*n]; // r-c+n
        dfs(0, n, col, usedCol, diag1, diag2, res);
        return res;
    }

    private void dfs(int r, int n, int[] col, boolean[] usedCol, boolean[] d1, boolean[] d2, List<List<String>> res) {
        if (r == n) {
            res.add(render(n, col));
            return;
        }
        for (int c = 0; c < n; c++) {
            int i1 = r + c, i2 = r - c + n;
            if (usedCol[c] || d1[i1] || d2[i2]) continue;
            usedCol[c] = d1[i1] = d2[i2] = true;
            col[r] = c;
            dfs(r + 1, n, col, usedCol, d1, d2, res);
            col[r] = -1;
            usedCol[c] = d1[i1] = d2[i2] = false;
        }
    }

    private List<String> render(int n, int[] col) {
        List<String> board = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[col[r]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }
}
