class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0, hi = 0;
        for (int w : weights) {
            lo = Math.max(lo, w);
            hi += w;
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, days, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int d = 1, cur = 0;
        for (int w : weights) {
            if (cur + w > cap) {
                d++;
                cur = 0;
                if (d > days) return false;
            }
            cur += w;
        }
        return true;
    }
}
