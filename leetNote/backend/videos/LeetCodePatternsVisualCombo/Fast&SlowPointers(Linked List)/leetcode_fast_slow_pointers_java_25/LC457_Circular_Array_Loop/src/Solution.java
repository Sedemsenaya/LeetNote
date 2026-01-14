public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            boolean forward = nums[i] > 0;

            int slow = i, fast = i;
            while (true) {
                slow = nextIndex(nums, slow, forward);
                if (slow == -1) break;

                fast = nextIndex(nums, fast, forward);
                if (fast == -1) break;
                fast = nextIndex(nums, fast, forward);
                if (fast == -1) break;

                if (slow == fast) return true;
            }

            // mark path as visited (set to 0)
            int idx = i;
            while (nums[idx] != 0 && (nums[idx] > 0) == forward) {
                int nxt = ((idx + nums[idx]) % n + n) % n;
                nums[idx] = 0;
                idx = nxt;
            }
        }
        return false;
    }

    private int nextIndex(int[] nums, int idx, boolean forward) {
        int n = nums.length;
        boolean dir = nums[idx] > 0;
        if (nums[idx] == 0 || dir != forward) return -1;

        int next = ((idx + nums[idx]) % n + n) % n;
        if (next == idx) return -1; // one-element loop not allowed
        return next;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,-1,1,2,2};
        int[] nums2 = {-1,2};
        System.out.println(new Solution().circularArrayLoop(nums1)); // true
        System.out.println(new Solution().circularArrayLoop(nums2)); // false
    }
}
