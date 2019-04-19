package advanced_class_02;

import java.util.Scanner;
import java.util.Stack;

import advanced_class_02.Code_05_MountainsAndFlame.Pair;

public class Code_05_MountainsAndFlame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
			System.out.println(communications(arr));
		}
		in.close();
	}

	public static int nextIndex(int size, int i) {
		return i < (size - 1) ? (i + 1) : 0;
	}

	public static long getInternalSum(int n) {
		return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
	}

	public static class Pair {
		public int value;
		public int times;

		public Pair(int value) {
			this.value = value;
			this.times = 1;
		}
	}


	// 默认可能有重复值
	public static long communications(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int size = arr.length;
		int maxIndex = 0;
		for (int i = 0; i < size; i++) {
			maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
		}
		int value = arr[maxIndex];
		int index = nextIndex(size, maxIndex);
		long res = 0L;
		Stack<Pair> stack = new Stack<Pair>();
		stack.push(new Pair(value));
		while (index != maxIndex) {
			value = arr[index];
			while (!stack.isEmpty() && stack.peek().value < value) {
				int K = stack.pop().times;
				res += getInternalSum( K) // C times 2
						+ 2 *  K;
			}
			if (!stack.isEmpty() && stack.peek().value == value) {
				stack.peek().times++;
			} else {
				stack.push(new Pair(value));
			}
			index = nextIndex(size, index);
		}
		while(stack.size() > 2) {
			int times = stack.pop().times;
			res += getInternalSum(times) + 2 * times;
		}
		if(stack.size() == 2) {
			int times = stack.pop().times;
			res += (stack.peek().times == 1 ? times : 2* times) + getInternalSum(times);
		}
		res += getInternalSum(stack.pop().times);
		return res;
	}
	
	
	
}