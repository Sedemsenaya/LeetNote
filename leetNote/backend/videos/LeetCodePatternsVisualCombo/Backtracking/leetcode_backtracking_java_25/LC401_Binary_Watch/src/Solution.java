import java.util.*;

public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        dfs(turnedOn, 0, 0, 0, res);
        return res;
    }

    // pos: 0..9, first 4 bits hour, next 6 bits minute
    private void dfs(int left, int pos, int hour, int minute, List<String> res) {
        if (hour > 11 || minute > 59) return;
        if (left == 0) {
            res.add(String.format("%d:%02d", hour, minute));
            return;
        }
        if (pos == 10) return;

        // choose pos
        if (pos < 4) dfs(left - 1, pos + 1, hour | (1 << pos), minute, res);
        else dfs(left - 1, pos + 1, hour, minute | (1 << (pos - 4)), res);

        // skip pos
        dfs(left, pos + 1, hour, minute, res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(1));
    }
}
