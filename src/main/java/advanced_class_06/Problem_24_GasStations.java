package advanced_class_06;
//加油问题
public class Problem_24_GasStations {

	public static boolean[] stations(int[] dis, int[] oil) {
		if (dis == null || oil == null || dis.length < 2
				|| dis.length != oil.length) {
			return null;
		}
		int init = changeDisArrayGetInit(dis, oil);//dis数组就变成了纯能值数组。
		return init == -1 ? new boolean[dis.length] : enlargeArea(dis, init);
	}

	public static int changeDisArrayGetInit(int[] dis, int[] oil) {
		int init = -1;
		for (int i = 0; i < dis.length; i++) {
			dis[i] = oil[i] - dis[i];
			if (dis[i] >= 0) {
				init = i;
			}
		}
		return init;
	}

	// init初始考察的点，纯能值大于等于0
	public static boolean[] enlargeArea(int[] pure, int init) {
		boolean[] res = new boolean[pure.length];
		// [x,end) 联通区
		// need 当前点到达联通区的头部的要求
		// rest 联通区还剩余的能量
		int cur = init; // 依次结算的点
		int end = nextIndex(init, pure.length); // 联通区的右边界，联通区的出发点没有表示
		int need = 0;
		int rest = 0;
		do {
			// init~init
			// 当前来到的start已经在连通区域中，可以确定后续的开始点一定无法转完一圈
			if (cur != init && cur == lastIndex(end, pure.length)) {
				break;
			}
			// 当前来到的cur不在连通区域中，就扩充连通区域
			if (pure[cur] < need) { // 从当前start出发，无法到达联通区域的头点
				need -= pure[cur];
			} else { // 如cur可以到达联通开始点，扩充连通区域的结束点
				rest += pure[cur] - need;
				need = 0;
				// 扩充连通区域的结束点,
				// 1) 走不下去了，停
				// 2) 转完一圈了，停
				while (rest >= 0 && end != cur) { 
					rest += pure[end];
					end = nextIndex(end, pure.length);
				}
				// 如果连通区域已经覆盖整个环，当前的start是良好出发点，进入2阶段
				if (rest >= 0) {
					res[cur] = true;
					connectGood(pure, lastIndex(cur, pure.length), init, res);
					break;
				}
			}
			cur = lastIndex(cur, pure.length);
		} while (cur != init);
		return res;
	}

	// 已知X的next方向上有一个良好出发点
	// X如果可以达到这个良好出发点，那么从X出发一定可以转一圈
	public static void connectGood(int[] dis, int X, int init, boolean[] res) {
		int need = 0;
		while (X != init) {
			if (dis[X] < need) {
				need -= dis[X];
			} else {
				res[X] = true;
				need = 0;
			}
			X = lastIndex(X, dis.length);
		}
	}

	public static int lastIndex(int index, int size) {
		return index == 0 ? (size - 1) : index - 1;
	}

	public static int nextIndex(int index, int size) {
		return index == size - 1 ? 0 : (index + 1);
	}

	// for test
	public static boolean[] test(int[] dis, int[] oil) {
		if (dis == null || oil == null || dis.length < 2
				|| dis.length != oil.length) {
			return null;
		}
		boolean[] res = new boolean[dis.length];
		for (int i = 0; i < dis.length; i++) {
			dis[i] = oil[i] - dis[i];
		}
		for (int i = 0; i < dis.length; i++) {
			res[i] = canWalkThrough(dis, i);
		}
		return res;
	}

	// for test
	public static boolean canWalkThrough(int[] arr, int index) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[index];
			if (sum < 0) {
				return false;
			}
			index = nextIndex(index, arr.length);
		}
		return true;
	}

	// for test
	public static void printArray(int[] dis, int[] oil) {
		for (int i = 0; i < dis.length; i++) {
			System.out.print(oil[i] - dis[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void printBooleanArray(boolean[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static int[] generateArray(int size, int max) {
		int[] res = new int[size];
		for (int i = 0; i < res.length; i++) {
			res[i] = (int) (Math.random() * max);
		}
		return res;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(boolean[] res1, boolean[] res2) {
		for (int i = 0; i < res1.length; i++) {
			if (res1[i] != res2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("hello");
		
		int max = 20;
		for (int i = 0; i < 5000000; i++) {
			int size = (int) (Math.random() * 20) + 2;
			int[] dis = generateArray(size, max);
			int[] oil = generateArray(size, max);
			int[] dis1 = copyArray(dis);
			int[] oil1 = copyArray(oil);
			int[] dis2 = copyArray(dis);
			int[] oil2 = copyArray(oil);
			boolean[] res1 = stations(dis1, oil1);
			boolean[] res2 = test(dis2, oil2);
			if (!isEqual(res1, res2)) {
				printArray(dis, oil);
				printBooleanArray(res1);
				printBooleanArray(res2);
				System.out.println("what a fucking day!");
				break;
			}
		}
	}

}
