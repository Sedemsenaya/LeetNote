public class Main {
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x = 0 ; x <= nums.length; x++) {
            int lo = 0, hi = size;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (tails[mid] < nums[x]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            tails[lo] = nums[x];
            if (lo == size) size++;
        }

        return size;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}