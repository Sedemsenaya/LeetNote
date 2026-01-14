import java.util.*;

public class Solution {
    static class StockSpanner {
        static class Pair {
            int price, span;
            Pair(int p, int s) { price = p; span = s; }
        }
        ArrayDeque<Pair> st = new ArrayDeque<>(); // decreasing price

        public int next(int price) {
            int span = 1;
            while (!st.isEmpty() && st.peek().price <= price) {
                span += st.pop().span;
            }
            st.push(new Pair(price, span));
            return span;
        }
    }

    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();
        System.out.println(sp.next(100)); // 1
        System.out.println(sp.next(80));  // 1
        System.out.println(sp.next(60));  // 1
        System.out.println(sp.next(70));  // 2
        System.out.println(sp.next(60));  // 1
        System.out.println(sp.next(75));  // 4
        System.out.println(sp.next(85));  // 6
    }
}
