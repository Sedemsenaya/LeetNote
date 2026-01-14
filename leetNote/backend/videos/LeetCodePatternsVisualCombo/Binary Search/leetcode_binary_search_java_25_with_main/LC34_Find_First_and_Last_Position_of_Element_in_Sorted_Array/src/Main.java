public class Main {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10}; int target = 8; int[] ans = new Solution().searchRange(nums, target); System.out.println(ans[0] + "," + ans[1]);
    }
}
