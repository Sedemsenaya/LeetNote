import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int lo = j + 1, hi = n - 1;
                while (lo < hi) {
                    long sum = (long) nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        lo++; hi--;
                        while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
                    } else if (sum < target) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(new Solution().fourSum(nums, 0));
        // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
    }
}
