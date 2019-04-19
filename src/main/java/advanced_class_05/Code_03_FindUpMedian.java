package advanced_class_05;

import java.util.Arrays;
//在两个长度相等的排序数组中找到上中位数
public class Code_03_FindUpMedian {

	public static int getUpMedian(int[] arr1, int[] arr2) {
		if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
			throw new RuntimeException("Your arr is invalid!");
		}
		int L1 = 0;
		int R1 = arr1.length - 1;
		int L2 = 0;
		int R2 = arr2.length - 1;
		int mid1 = 0;
		int mid2 = 0;
		while (L1 < R1) {
			mid1 = (L1 + R1) / 2;
			mid2 = (L2 + R2) / 2;
			if(arr1[mid1] == arr2[mid2]) {
				return arr1[mid1];
			}else if(arr1[mid1] > arr2[mid2]){
				if((int)((R1-L1+1)&1) ==0) { //长度为偶数
					R1 = mid1;
					L2 = mid2 + 1;
				}else {//长度为奇数
					if(arr2[mid2] >= arr1[mid1-1]) {
						return arr2[mid2];
					}else {
						R1 = mid1-1;
						L2 = mid2+1;
					}
				}
			}else { // arr1[mid1] < arr2[mid2]
				if((int)((R1-L1+1)&1) ==0) { //长度为偶数
					L1 = mid1+1;
					R2 = mid2;
				}else {//长度为奇数
					if(arr1[mid1] >= arr2[mid2-1]) {
						return arr1[mid1];
					}else {
						L1 = mid1+1;
						R2 = mid2-1;
					}
				}
			}
		}
		// L1..R1  L2..R2
		return Math.min(arr1[L1], arr2[L2]);
	}

	// For test, this method is inefficient but absolutely right
	public static int findForTest(int[] arr1, int[] arr2) {
		if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
			throw new RuntimeException("Your arr is invalid!");
		}
		int[] arrAll = new int[arr1.length + arr2.length];
		for (int i = 0; i != arr1.length; i++) {
			arrAll[i * 2] = arr1[i];
			arrAll[i * 2 + 1] = arr2[i];
		}
		Arrays.sort(arrAll);
		return arrAll[(arrAll.length / 2) - 1];
	}

	public static int[] generateSortedArray(int len, int maxValue) {
		int[] res = new int[len];
		for (int i = 0; i != len; i++) {
			res[i] = (int) (Math.random() * (maxValue + 1));
		}
		Arrays.sort(res);
		return res;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int len = 10;
		int maxValue1 = 20;
		int maxValue2 = 50;
		int[] arr1 = generateSortedArray(len, maxValue1);
		int[] arr2 = generateSortedArray(len, maxValue2);
		printArray(arr1);
		printArray(arr2);
		System.out.println(getUpMedian(arr1, arr2));
		System.out.println(findForTest(arr1, arr2));

	}

}
