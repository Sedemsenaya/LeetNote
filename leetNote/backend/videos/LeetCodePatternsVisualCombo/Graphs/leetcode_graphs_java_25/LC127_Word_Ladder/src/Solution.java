import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        ArrayDeque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        Set<String> seen = new HashSet<>();
        seen.add(beginWord);

        int steps = 1;
        while (!q.isEmpty()) {
            for (int sz = q.size(); sz > 0; sz--) {
                String w = q.poll();
                if (w.equals(endWord)) return steps;
                char[] a = w.toCharArray();
                for (int i = 0; i < a.length; i++) {
                    char old = a[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) continue;
                        a[i] = ch;
                        String nw = new String(a);
                        if (dict.contains(nw) && seen.add(nw)) q.add(nw);
                    }
                    a[i] = old;
                }
            }
            steps++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog"))); // 5
    }
}
