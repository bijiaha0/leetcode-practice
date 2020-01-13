package Amazon.ImplementStackByTwoQueues;
import java.util.LinkedList;
import java.util.Queue;
public class MyStack {
    Queue<Integer> que;
    public MyStack() {
        que = new LinkedList<>();
    }
    public void push(int x) {
        que.add(x);
        for(int i=0; i<que.size()-1; i++) {
            que.add(que.poll());
        }
    }
    public int pop() {
        return que.remove();
    }
    public int peek() {
        return que.peek();
    }
    public boolean empty() {
        return que.isEmpty();
    }
}
