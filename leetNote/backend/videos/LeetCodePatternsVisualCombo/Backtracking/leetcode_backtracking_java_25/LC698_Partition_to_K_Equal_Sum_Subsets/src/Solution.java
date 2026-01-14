import java.util.*;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        long sum = 0;
        for (int x : nums) sum += x;
        if (sum % k != 0) return false;
        int target = (int)(sum / k);

        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
        }
        if (nums[0] > target) return false;

        int[] bucket = new int[k];
        return dfs(nums, 0, bucket, target);
    }

    private boolean dfs(int[] nums, int idx, int[] bucket, int target) {
        if (idx == nums.length) return true;
        int val = nums[idx];
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + val > target) continue;
            bucket[i] += val;
            if (dfs(nums, idx + 1, bucket, target)) return true;
            bucket[i] -= val;
            if (bucket[i] == 0) break; // symmetry prune
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4)); // true
    }
}
