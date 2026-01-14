class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long lo = 2, hi = num / 2;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sq = mid * mid;
            if (sq == num) return true;
            if (sq < num) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
