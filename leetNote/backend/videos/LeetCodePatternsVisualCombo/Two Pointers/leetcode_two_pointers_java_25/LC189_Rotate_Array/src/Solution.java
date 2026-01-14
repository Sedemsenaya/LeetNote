import java.util.*;

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        rev(nums, 0, n - 1);
        rev(nums, 0, k - 1);
        rev(nums, k, n - 1);
    }

    private void rev(int[] a, int l, int r) {
        while (l < r) {
            int t = a[l]; a[l] = a[r]; a[r] = t;
            l++; r--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        new Solution().rotate(a, 3);
        System.out.println(Arrays.toString(a)); // [5,6,7,1,2,3,4]
    }
}
