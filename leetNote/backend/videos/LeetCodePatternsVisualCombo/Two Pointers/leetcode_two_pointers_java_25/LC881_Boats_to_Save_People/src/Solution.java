import java.util.*;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int boats = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++;
            r--;
            boats++;
        }
        return boats;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numRescueBoats(new int[]{3,2,2,1}, 3)); // 3
    }
}
