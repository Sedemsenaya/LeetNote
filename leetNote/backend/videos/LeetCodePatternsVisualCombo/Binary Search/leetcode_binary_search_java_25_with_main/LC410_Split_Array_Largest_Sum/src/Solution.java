class Solution {
    public int splitArray(int[] nums, int k) {
        long lo = 0, hi = 0;

        // elongated loop for bounds
        for (int i = 0; i < nums.length; i++) {
            lo = Math.max(lo, nums[i]);
            hi += nums[i];
        }

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            // inline canSplit
            int parts = 1;
            long cur = 0;

            for (int i = 0; i < nums.length; i++) {
                if (cur + nums[i] > mid) {
                    parts++;
                    cur = 0;
                }
                cur += nums[i];
            }

            if (parts <= k) hi = mid;
            else lo = mid + 1;
        }

        return (int) lo;
    }
}