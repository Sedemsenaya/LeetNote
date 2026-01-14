public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // phase 1: meet inside cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // phase 2: find entrance
        int p1 = nums[0];
        int p2 = slow;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(new Solution().findDuplicate(nums)); // 2
    }
}
