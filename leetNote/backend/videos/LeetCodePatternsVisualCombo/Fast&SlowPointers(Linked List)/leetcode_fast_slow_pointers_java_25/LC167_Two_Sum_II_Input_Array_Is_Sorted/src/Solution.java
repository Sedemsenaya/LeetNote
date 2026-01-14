import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) return new int[]{i + 1, j + 1};
            if (sum < target) i++;
            else j--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        System.out.println(Arrays.toString(new Solution().twoSum(numbers, 9))); // [1,2]
    }
}
