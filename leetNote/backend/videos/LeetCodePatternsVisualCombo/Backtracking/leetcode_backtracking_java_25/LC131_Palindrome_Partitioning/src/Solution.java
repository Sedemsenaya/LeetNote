import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] pal = precompute(s);
        dfs(s, 0, pal, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int start, boolean[][] pal, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (!pal[start][end]) continue;
            path.add(s.substring(start, end + 1));
            dfs(s, end + 1, pal, path, res);
            path.remove(path.size() - 1);
        }
    }

    private boolean[][] precompute(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                pal[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || pal[i + 1][j - 1]);
            }
        }
        return pal;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
    }
}
