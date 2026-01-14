public class Solution {
    public int majorityElement(int[] nums) {
        int cand = 0, cnt = 0;
        for (int x : nums) {
            if (cnt == 0) cand = x;
            cnt += (x == cand) ? 1 : -1;
        }
        return cand;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{2,2,1,1,1,2,2})); // 2
    }
}
