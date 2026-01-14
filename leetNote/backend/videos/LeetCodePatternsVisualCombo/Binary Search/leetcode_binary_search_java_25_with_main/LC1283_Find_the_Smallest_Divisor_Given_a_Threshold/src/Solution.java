class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 0;
        for (int x : nums) hi = Math.max(hi, x);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (sumDiv(nums, mid) <= threshold) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private long sumDiv(int[] nums, int d) {
        long sum = 0;
        for (int x : nums) sum += (x + (long)d - 1) / d;
        return sum;
    }
}
