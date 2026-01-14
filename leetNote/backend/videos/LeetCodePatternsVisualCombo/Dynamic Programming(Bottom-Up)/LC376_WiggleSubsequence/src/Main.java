// LC376_WiggleSubsequence.java
public class Main {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1]) {
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[n-1], down[n-1]);
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5})); // 6
        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8})); // 7
    }
}
