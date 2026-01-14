import java.util.*;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, w = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) nums1[w--] = nums1[i--];
            else nums1[w--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        new Solution().merge(a, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(a)); // [1,2,2,3,5,6]
    }
}
