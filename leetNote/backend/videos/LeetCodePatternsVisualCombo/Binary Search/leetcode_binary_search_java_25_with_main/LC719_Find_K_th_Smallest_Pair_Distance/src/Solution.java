import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (countPairs(nums, mid) >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private int countPairs(int[] nums, int dist) {
        int n = nums.length;
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && nums[j] - nums[i] <= dist) j++;
            count += j - i - 1;
        }
        return count;
    }
}
