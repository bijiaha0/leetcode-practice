package Amazon.Flatten2DVector;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/*
* https://www.jiuzhang.com/solution/flatten-2d-vector/
* */
public class Vector2D implements Iterator<Integer> {

    Stack<List<Integer>> stack = new Stack<>();

    Stack<Integer> stackj;
    //
    void pushListListToStack(List<List<Integer>> vec2d) {
        Stack<List<Integer>> temp = new Stack<>();
        for (List<Integer> nested : vec2d) {
            temp.push(nested);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    //
    void pushListToStack(List<Integer> vec) {
        Stack<Integer> temp = new Stack<>();
        for (Integer nested : vec) {
            temp.push(nested);
        }
        while (!temp.isEmpty()) {
            stackj.push(temp.pop());
        }
    }

    public Vector2D(List<List<Integer>> vec2d) {
        pushListListToStack(vec2d);
        // Initialize your data structure here
        stackj = new Stack<>();
    }

    public Integer next() {
        // Write your code here
        if(!hasNext()) {
            return null;
        }
        return stackj.pop();
    }

    public boolean hasNext() { // 准备下一个元素
        // Write your code here
        while (stackj.isEmpty() && !stack.isEmpty())
            pushListToStack(stack.pop());
        return !stackj.isEmpty();
    }

    public void remove() {}
}