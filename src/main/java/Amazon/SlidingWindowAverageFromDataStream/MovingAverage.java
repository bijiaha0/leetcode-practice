package Amazon.SlidingWindowAverageFromDataStream;
import java.util.LinkedList;
import java.util.Queue;
/*
*  https://www.lintcode.com/problem/moving-average-from-data-stream/solution
*  方便快速求一段的和 ：  a[k]+a[k+1]+...+a[j] = s[j]-s[k-1]
*  怎么快求s[i]：   s[i] = s[i-1]+a[i]
*  前缀和数组
*  google----电面
* */
public class MovingAverage {
    private Queue<Integer> que;
    private double sum = 0;
    private int size;
    public MovingAverage(int size) {
        que = new LinkedList<Integer>();
        this.size = size;
    }
    public double next(int val) {
        sum += val;
        if (que.size() == size) {
            sum = sum - que.poll();
        }
        que.offer(val);
        return sum / que.size();
    }
}
