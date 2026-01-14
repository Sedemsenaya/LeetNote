import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());
        int[] indeg = new int[numCourses];
        for (int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indeg[i] == 0) q.add(i);

        int[] order = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int v : g.get(u)) if (--indeg[v] == 0) q.add(v);
        }
        return idx == numCourses ? order : new int[0];
    }

    public static void main(String[] args) {
        int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(new Solution().findOrder(4, pre)));
    }
}
