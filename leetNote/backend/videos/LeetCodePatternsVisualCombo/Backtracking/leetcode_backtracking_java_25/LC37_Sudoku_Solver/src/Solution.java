import java.util.*;

public class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                int d = board[r][c] - '0';
                row[r][d] = col[c][d] = box[boxId(r, c)][d] = true;
            }
        }
        dfs(board, 0, row, col, box);
    }

    private boolean dfs(char[][] b, int idx, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (idx == 81) return true;
        int r = idx / 9, c = idx % 9;
        if (b[r][c] != '.') return dfs(b, idx + 1, row, col, box);

        int bid = boxId(r, c);
        for (int d = 1; d <= 9; d++) {
            if (row[r][d] || col[c][d] || box[bid][d]) continue;
            b[r][c] = (char) ('0' + d);
            row[r][d] = col[c][d] = box[bid][d] = true;
            if (dfs(b, idx + 1, row, col, box)) return true;
            row[r][d] = col[c][d] = box[bid][d] = false;
            b[r][c] = '.';
        }
        return false;
    }

    private int boxId(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }

    private static void print(char[][] b) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) System.out.print(b[r][c] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        new Solution().solveSudoku(board);
        print(board);
    }
}
