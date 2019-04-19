package tju.basic_class_01;
import java.util.Arrays;
/*
堆：
* 整个数组先把它建成堆heapInsert，然后交换，再依次排出最大值，然后进行堆减。
* 建立大根堆的时间复杂度是O(N)的；之后堆减的时间复杂度是O(N*logN)
* 完全二叉树的节点数是N，它的高度是O(logN)
时间复杂度O(N*logN)，额外空间复杂度O(1)，实现不能做到稳定性
关键步骤:heapInsert, heapify，堆的扩大和缩小操作
注意:
1，堆排序中，建立堆的操作O(N) 2，堆排序的核心数据结构:堆，也可以说是优先级队列
* */
public class Code_03_HeapSort {
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		//生成大根堆
		for (int i = 0; i < arr.length; i++) {//O(N)次
			heapInsert(arr, i);//O(logN)
		}
		int heapSize = arr.length;
		//--变量表示先进行变量的自增或者自减，然后再参与运算。
		swap(arr, 0, --heapSize);
		while (heapSize > 0) {//O(N)次
			heapify(arr, 0, heapSize);//O(logN)
			swap(arr, 0, --heapSize);
		}
	}
	//前提：arr[index]位置的数变大
	//调成大根堆
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}
	//arr[i]位置的值发生了变化，并且是变小，堆大小是size(arr[0~size-1]),请重新调整成大根堆
	public static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;//index表示父的下标，left表示左孩子的位置。
		//如果右孩子有的话，和左孩子的值比较，最大的值的下标，作为largest的值
		while (left < heapSize) {//限制左孩子不越界，(left+1)表示右孩子的位置。
			int largest = left + 1 < heapSize //右孩子如果不越界
					&& arr[left + 1] > arr[left] //右孩子的值大于左孩子的值
					? left + 1 : left;//我的孩子中较大元素的下标请你给我
			//两个孩子和父节点的值比较，最大的值的下标，作为largest的值
			largest = arr[largest] > arr[index] ? largest : index;//父和子，哪个大，谁就作为largest
			//如果最大的值的下标已经是父节点的位置，过程停止
			if (largest == index) {//经历过一圈后，我发现我的父节点还是最大的，我就不用动了。整个while退出。
				break;
			}
			//选出来的largest的位置一定不是i位置，是i位置的左右两个孩子中，较大数的下标
			swap(arr, largest, index);//我孩子的某个值比我大，我要往下换,那个孩子的位置要换成largest。
			index = largest;
			left = index * 2 + 1;//继续下一次while循环。
		}
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}
}
