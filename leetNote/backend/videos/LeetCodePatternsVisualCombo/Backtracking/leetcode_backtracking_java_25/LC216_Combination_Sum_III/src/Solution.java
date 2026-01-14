import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int start, int k, int target, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            if (target == 0) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > target) break;
            path.add(i);
            dfs(i + 1, k, target - i, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7)); // [[1,2,4]]
    }
}
