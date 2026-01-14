import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(best - target)) best = sum;
                if (sum < target) l++;
                else if (sum > target) r--;
                else return sum;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{-1,2,1,-4}, 1)); // 2
    }
}
