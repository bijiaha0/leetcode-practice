package tju.basic_class_01;
import java.util.Arrays;
//数组操作
public class ArrayOperation {
	//冒泡排序:(时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性)
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int end = arr.length - 1; end > 0; end--) {
			for (int i = 0; i < end; i++) {
				if (arr[i] > arr[i + 1]) {//如果前一个位置比后一个位置大，则交换位置
					swap(arr, i, i + 1);
				}
			}
		}
	}
	//插入排序(扑克牌):时间复杂度O(N^2)，额外空间复杂度O(1)，实现可以做到稳定性。
	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {//从当前位置往前看
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}
	//选择排序，
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);/*内层循环遍历一遍，然后只交换一次。*/
		}
	}
	//
	//+++++++++++++++++++++++++++++常用代码+++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//交换顺序
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	// 数组比较
	public static void comparator(int[] arr) {
		System.out.println();
		Arrays.sort(arr);
	}
	// 随机生成一个数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		//Math.random() - > double [0,1)
		//Math.random() * X - > double - > [0,X)
		//(int)(Math.random() * X) - > int - >[0,X-1]
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];//生成0到maxSize范围内的一个随机整数
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());//每个位置产生一个随机值(有正有负)
		}
		return arr;
	}
	// 拷贝数组
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
	/*比较两个数组的每个位置的值是否相等*/
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
	// 打印数组
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int testTime = 500000;/*测试次数*/
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);//拷贝一份
			bubbleSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {//调用自定义的Equal方法，比较两个数组是否相等。
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
}
