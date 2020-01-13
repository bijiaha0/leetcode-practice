package Amazon.MergeSortedArray;

/**
 * https://www.jiuzhang.com/solutions/merge-sorted-array/
 */
public class Solution {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }


    public static void s1(int[] a, int n, int[] b, int m) {
        int i = n - 1;
        int j = m - 1;
        int index = n + m - 1;
        while (i >= 0 && j >= 0) {
            if(a[i]>b[j]){
                a[index--]=a[i--];
            }else {
                a[index--]=b[j--];
            }
        }
        while (i>=0){
            a[index--] = a[i--];
        }
        while (j>=0){
            a[index--] = a[j--];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,6,0,0,0,0};
        int[] b = {2,5,8,9};
        s1(a, 4, b, 4);
        for(int e :a){
            System.out.println(e);
        }
    }
}
