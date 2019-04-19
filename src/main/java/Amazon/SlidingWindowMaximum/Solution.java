package Amazon.SlidingWindowMaximum;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
/*
* https://www.lintcode.com/problem/sliding-window-maximum/solution
* 给出一个可能包含重复的整数数组，和一个大小为 k 的滑动窗口,
* 从左到右在数组中滑动这个窗口，找到数组中每个窗口内的最大值。
* */
public class Solution {
    int[] a;
    void inQueue(Deque<Integer> deque, int pos) {
        while (!deque.isEmpty() && a[deque.peekLast()] <= a[pos]) {//返回此deque队列的尾部
            deque.pollLast();//pollLast(): 返回并移除队尾元素
        }
        deque.offer(pos);
    }
    /*
    * 我们可以用一个队列来存储每个窗口的数，然后选出最大的，不过这样代价有点大
其实不必每个窗口的每个数都存下来，我们用一个双向队列deque来存储，注意：我们在这存的是数组元素的索引
如果新来的值比队列尾部的数小，那就追加到后面，因为它可能在前面的最大值划出窗口后成为最大值
如果新来的值比尾部的大，那就删掉尾部（因为有更大的在后面，所以它不会成为最大值，划出也是它先划出，不影响最大值），再追加到后面，循环下去直到小于
如果追加的值比的索引跟队列头部的值的索引超过窗口大小，那就删掉头部的值
其实这样每次队列的头都是最大的那个
    *
    * */
    void outQueue(Deque<Integer> deque, int pos) {
        if (deque.peekFirst() == pos) {//peekFirst(): 获取队头元素但不移除
            deque.pollFirst();
        }
    }
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        a = nums;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        if (nums.length == 0) {
            return ans;
        }
        for (int i = 0; i < k - 1; i++) {
            inQueue(deque, i);
        }
        for(int i = k - 1; i < nums.length; i++) {
            inQueue(deque, i);
            ans.add(a[deque.peekFirst()]);
            outQueue(deque, i - k + 1);
        }
        return ans;
    }
}
