import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int[] tmp = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (k == 0 || tmp[k - 1] != nums1[i]) tmp[k++] = nums1[i];
                i++; j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        return Arrays.copyOf(tmp, k);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersection(new int[]{1,2,2,1}, new int[]{2,2}))); // [2]
    }
}
