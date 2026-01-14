class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long need = (long) m * k;
        if (need > bloomDay.length) return -1;

        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int d : bloomDay) {
            lo = Math.min(lo, d);
            hi = Math.max(hi, d);
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canMake(bloomDay, m, k, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean canMake(int[] a, int m, int k, int day) {
        int bouquets = 0, run = 0;
        for (int d : a) {
            if (d <= day) {
                run++;
                if (run == k) {
                    bouquets++;
                    run = 0;
                    if (bouquets >= m) return true;
                }
            } else {
                run = 0;
            }
        }
        return bouquets >= m;
    }
}
