import java.util.*;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int l = 0, r = n - 1, w = n - 1;
        while (l <= r) {
            int a = nums[l] * nums[l];
            int b = nums[r] * nums[r];
            if (a > b) { ans[w--] = a; l++; }
            else { ans[w--] = b; r--; }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortedSquares(new int[]{-4,-1,0,3,10}))); // [0,1,9,16,100]
    }
}
