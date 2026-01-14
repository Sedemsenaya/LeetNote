public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] seen = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dfs(board, word, 0, r, c, seen)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] b, String w, int i, int r, int c, boolean[][] seen) {
        if (i == w.length()) return true;
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length) return false;
        if (seen[r][c] || b[r][c] != w.charAt(i)) return false;

        seen[r][c] = true;
        boolean ok = dfs(b, w, i + 1, r + 1, c, seen)
                || dfs(b, w, i + 1, r - 1, c, seen)
                || dfs(b, w, i + 1, r, c + 1, seen)
                || dfs(b, w, i + 1, r, c - 1, seen);
        seen[r][c] = false;
        return ok;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new Solution().exist(board, "ABCCED")); // true
        System.out.println(new Solution().exist(board, "SEE"));    // true
        System.out.println(new Solution().exist(board, "ABCB"));   // false
    }
}
