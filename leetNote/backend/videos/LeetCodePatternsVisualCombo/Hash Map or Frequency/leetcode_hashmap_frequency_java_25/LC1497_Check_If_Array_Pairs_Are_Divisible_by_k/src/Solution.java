public class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] cnt = new int[k];
        for (int x : arr) {
            int r = x % k;
            if (r < 0) r += k;
            cnt[r]++;
        }
        if ((cnt[0] & 1) == 1) return false;
        for (int r = 1; r <= k / 2; r++) {
            if (r == k - r) {
                if ((cnt[r] & 1) == 1) return false;
            } else {
                if (cnt[r] != cnt[k - r]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5)); // true
        System.out.println(new Solution().canArrange(new int[]{1,2,3,4,5,6}, 7)); // true
    }
}
