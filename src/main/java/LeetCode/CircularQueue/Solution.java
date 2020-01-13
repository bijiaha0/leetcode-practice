package LeetCode.CircularQueue;
/**
 * 队列为空的判断条件：head==tail;
 * 队列为满的判断条件：(tail+1)%n == head;
 */
public class Solution {
    String[] items;
    int n;
    int head=0;
    int tail=0;
    Solution(int capacity){
        items = new String[capacity];
        n=capacity;
    }
    boolean enqueue(String item){
        if((tail+1)%n==head) return false;
        items[tail] = item;
        tail++;
        return true;
    }
    String dequeue(){
        if(head==tail) return null;
        String res = items[head];
        head = (head+1)%n;
        return res;
    }
}
