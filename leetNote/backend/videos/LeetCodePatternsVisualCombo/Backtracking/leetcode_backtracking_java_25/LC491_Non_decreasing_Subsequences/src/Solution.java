import java.util.*;

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, Integer.MIN_VALUE, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int idx, int prev, List<Integer> path, List<List<Integer>> res) {
        if (path.size() >= 2) res.add(new ArrayList<>(path));
        if (idx == nums.length) return;

        boolean[] used = new boolean[201]; // -100..100
        for (int i = idx; i < nums.length; i++) {
            int v = nums[i];
            if (v < prev) continue;
            if (used[v + 100]) continue;
            used[v + 100] = true;
            path.add(v);
            dfs(nums, i + 1, v, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{4,6,7,7}));
    }
}
