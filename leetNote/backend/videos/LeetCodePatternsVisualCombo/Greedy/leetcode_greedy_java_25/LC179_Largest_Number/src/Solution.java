import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        String[] a = new String[nums.length];
        for (int i = 0; i < nums.length; i++) a[i] = String.valueOf(nums[i]);
        Arrays.sort(a, (x,y) -> (y + x).compareTo(x + y));
        if (a[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : a) sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{3,30,34,5,9})); // 9534330
    }
}
