public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long best = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            best = Math.max(best, sum);
        }
        return (double) best / k;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4)); // 12.75
    }
}
