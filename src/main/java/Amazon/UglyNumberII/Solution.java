package Amazon.UglyNumberII;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * https://www.jiuzhang.com/solutions/ugly-number-ii/
 * 在HashSet中，基本的操作都是有HashMap底层实现的，因为HashSet底层是用HashMap存储数据的。
 * 当向HashSet中添加元素的时候，首先计算元素的hashcode值，
 * 然后用这个（元素的hashcode）%（HashMap集合的大小）+1计算出这个元素的存储位置，
 * 如果这个位置位空，就将元素添加进去；如果不为空，则用equals方法比较元素是否相等，
 * 相等就不添加，否则就在屁股后面添加。
 */
public class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> Q = new PriorityQueue<Long>();
        HashSet<Long> inQ = new HashSet<Long>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        for (int i = 0; i < 3; i++) {
            Q.add(primes[i]);
            inQ.add(primes[i]);
        }
        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i++) {
            number = Q.poll();
            for (int j = 0; j < 3; j++) {
                if (!inQ.contains(number * primes[j])) {
                    Q.add(number * primes[j]);
                    inQ.add(number * primes[j]);
                }
            }
        }
        return number.intValue();
    }
}
