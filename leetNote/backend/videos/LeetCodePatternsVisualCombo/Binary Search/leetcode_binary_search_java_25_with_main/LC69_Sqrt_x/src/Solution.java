class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        long lo = 1, hi = x / 2;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sq = mid * mid;
            if (sq == x) return (int) mid;
            if (sq < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return (int) hi;
    }
}
