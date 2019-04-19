package Amazon.MaximumSwap;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Solution2 {
    public int maximumSwap(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        int n = ch.length;
        //定义一个大跟堆
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.y == b.y) {
                    return b.x - a.x;
                }
                return b.y - a.y;
            }
        });
        for (int i = 0; i < n; ++i) {
            pq.offer(new Pair(i, ch[i]));
        }
        for (int i = 0; i < n; ++i) {
            Pair curt = pq.poll();
            if (curt.y == ch[i]) {
                continue;
            }
            num = swap(num, i, curt.x);
            break;
        }
        return num;
    }
    public class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int swap(int num, int i, int j) {
        String s = "" + num;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        return Integer.parseInt(sb.toString());
    }
}