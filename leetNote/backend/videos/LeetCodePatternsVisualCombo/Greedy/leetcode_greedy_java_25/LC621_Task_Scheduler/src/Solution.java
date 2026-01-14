import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char t : tasks) cnt[t - 'A']++;
        Arrays.sort(cnt);
        int max = cnt[25] - 1;
        int idle = max * n;
        for (int i = 24; i >= 0 && cnt[i] > 0; i--) {
            idle -= Math.min(cnt[i], max);
        }
        return idle > 0 ? idle + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval(new char[]{'A','A','A','B','B','B'}, 2)); // 8
    }
}
