import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1;
        int hi = position[position.length - 1] - position[0];

        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (canPlace(position, m, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private boolean canPlace(int[] pos, int m, int dist) {
        int count = 1;
        int last = pos[0];
        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - last >= dist) {
                count++;
                last = pos[i];
                if (count >= m) return true;
            }
        }
        return count >= m;
    }
}
