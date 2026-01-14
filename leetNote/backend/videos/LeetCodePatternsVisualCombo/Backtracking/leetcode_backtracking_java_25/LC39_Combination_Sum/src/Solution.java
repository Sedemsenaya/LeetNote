import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] a, int start, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < a.length; i++) {
            if (a[i] > target) break;
            path.add(a[i]);
            dfs(a, i, target - a[i], path, res); // can reuse
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,6,7}, 7));
    }
}
