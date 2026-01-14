// LeetCode 152: Maximum Product Subarray (bottom-up DP)


  public class Main {

    public static int maxProduct(int[] nums) {
        int n = nums.length;

        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int best = nums[0];

        for (int i = 1; i < n; i++) {
            int x = nums[i];

            dpMax[i] = Math.max(Math.max(x, dpMax[i - 1] * x), dpMin[i - 1] * x);
            dpMin[i] = Math.min(Math.min(x, dpMax[i - 1] * x), dpMin[i - 1] * x);

            best = Math.max(best, dpMax[i]);
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4})); // 6
        System.out.println(maxProduct(new int[]{-2,0,-1}));  // 0
    }
}

