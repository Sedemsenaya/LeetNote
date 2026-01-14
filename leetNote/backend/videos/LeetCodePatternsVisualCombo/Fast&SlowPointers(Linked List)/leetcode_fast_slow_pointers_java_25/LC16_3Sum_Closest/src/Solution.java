import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(target - best)) best = sum;
                if (sum < target) lo++;
                else if (sum > target) hi--;
                else return sum;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(new Solution().threeSumClosest(nums, 1)); // 2
    }
}
