class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int lo = 0, hi = m;
        while (lo <= hi) {
            int i = lo + (hi - lo) / 2;
            int j = totalLeft - i;

            int aLeft = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int aRight = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int bLeft = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int bRight = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (aLeft <= bRight && bLeft <= aRight) {
                if (((m + n) & 1) == 1) return Math.max(aLeft, bLeft);
                return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
            } else if (aLeft > bRight) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
        }
        return 0.0;
    }
    public class Main {
    public static void main(String[] args) {
        int[] a = {1,3}; int[] b = {2}; System.out.println(new Solution().findMedianSortedArrays(a, b));
    }
}

}


// public class Main {
//     public static void main(String[] args) {
//         int[] a = {1,3}; int[] b = {2}; System.out.println(new Solution().findMedianSortedArrays(a, b));
//     }
// }

