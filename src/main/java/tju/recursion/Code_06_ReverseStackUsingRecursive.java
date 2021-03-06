package tju.recursion;
import java.util.Stack;
/*
给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能
使用递归函数。如何实现?
* */
public class Code_06_ReverseStackUsingRecursive {
	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
	/*
	* 移除栈底元素。并返回。
	* */
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();//栈中弹出一个，用result接住
		if (stack.isEmpty()) {
			return result;//如果此时stack是空的话，直接返回弹出的result
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		reverse(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}
	}
}
