import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0, j = n - 1, k = n - 1;
        while (i <= j) {
            int left = nums[i] * nums[i];
            int right = nums[j] * nums[j];
            if (left > right) {
                ans[k--] = left;
                i++;
            } else {
                ans[k--] = right;
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(new Solution().sortedSquares(nums))); // [0,1,9,16,100]
    }
}
