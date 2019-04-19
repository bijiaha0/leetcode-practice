package tju.basic_class_01;
import java.util.Arrays;
/*归并排序*/
/*
* 归并排序
时间复杂度O(N*logN)，额外空间复杂度O(N)，实现可以做到稳定性
注意:
1，库函数中排序的实现是综合排序，比如插入+快速;比如为了稳定性， 排序算法往往是快排+堆排序 2，归并排序和快速排序，都一定存在非递归的实现 3，归并排序，存在额外空间复杂度O(1)的实现，但是非常难，你不需要 掌握
4，归并排序的扩展，小和问题，逆序对
* */
public class Code_05_MergeSort {

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}
	public static void mergeSort(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		int mid = L + ((R - L) >> 1);//L和R中点的位置
		mergeSort(arr, L, mid);//左部分排好
		mergeSort(arr, mid + 1, R);//右部分排好
		merge(arr, L, mid, R);//按左右部分大小关系合并
	}
	public static void merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		//在P1和P2都不越界的时候，发生如下的行为
		while (p1 <= M && p2 <= R) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];//help是辅助数组。
		}
		//P1和P2一定有一个越界，另一个不越界。
		//p2越界，直接把p1的剩余部分，直接拷贝到辅助数组中去。
		while (p1 <=  M) {
			help[i++] = arr[p1++];
		}
		//p1越界，直接把p2的剩余部分，直接拷贝到辅助数组中去。
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		//help有序的，拷贝回原数组。
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
	}
	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
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

	// for test
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

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort(arr1);
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
		mergeSort(arr);
		printArray(arr);

	}

}
