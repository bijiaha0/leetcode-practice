package tju.basic_class_01;
/*
随机快速排序
时间复杂度O(N*logN)，额外空间复杂度O(logN)，常规实现做不到稳定 性。
* */
import java.util.Arrays;
//快排
public class Code_04_QuickSort {
	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}
    //随机快速排序(时间复杂度O(N*logN)，空间复杂度O(LogN))
	//把arr[L,R]上排好序
	public static void quickSort(int[] arr, int L, int R) {
		if (L < R) {//arr[L..R]上不止一个数
			swap(arr, L + (int) (Math.random() * (R - L + 1)), R);//随机选一个位置和R上的位置交换。
			int[] p = partition(arr, L, R);//p数组是等于区域的[左位置，右位置]
			quickSort(arr, L, p[0] - 1);//P[0]等于区域的最左位置
			quickSort(arr, p[1] + 1, R);//P[1]等于区域的最右位置
		}
	}
	//默认以arr[R]作为划分值，在arr[L,R]上，<  ==  >
	//返回一个数组，int[] res,长度一定是2，res[0]代表的是等于区域的左边界，
	//res[1]代表的是等于区域的右边界，也就是最右的位置。
	public static int[] partition(int[] arr, int L, int R) {
		int less = L - 1;//小于区域的右边界
		int more = R;//大于区域的左边界
		int index = L;//当前数的下标
		while (index < more) {//arr[R]做划分
			if (arr[index] < arr[R]) {//当前数小于arr[R]
				swap(arr, ++less, index++);
			} else if (arr[index] > arr[R]) {//当前数大于arr[R]
				swap(arr, --more, index);
			} else {
				index++;
			}
		}
		swap(arr, more, R);//more位置和R位置的值做交换
		return new int[] { less + 1, more };//返回值表示的是等于区域的左边界和右边界。
	}
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
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);
	}
}
