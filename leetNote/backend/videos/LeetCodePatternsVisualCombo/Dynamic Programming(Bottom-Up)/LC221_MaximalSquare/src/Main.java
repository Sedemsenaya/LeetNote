// LeetCode 221: Maximal Square (2D bottom-up DP)
public class Main {

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSide = 0;

        for (int r = 1; r <= rows; r++) {
            for (int c = 1; c <= cols; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    dp[r][c] = Math.min(
                            Math.min(dp[r - 1][c], dp[r][c - 1]),
                            dp[r - 1][c - 1]
                    ) + 1;
                    maxSide = Math.max(maxSide, dp[r][c]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        char[][] m = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalSquare(m)); // 4
    }
}
