package Amazon.QuickSort;
import java.util.Random;
/**
 * Email: clickgwas@gmail.com
 * https://www.jiuzhang.com/solution/quick-sort/
 * 快排模板
 */
public class Solution {

    public Random rand;
    public void sortIntegers2(int[] A) {
        rand = new Random();
        quickSort(A, 0, A.length - 1);
    }

    public void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int index = rand.nextInt(end - start + 1)  + start;
        int pivot = A[index];
        int left = start;
        int right = end;

        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left ++;
            }
            while (left <= right && A[right] > pivot) {
                right --;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                left ++;
                right --;
            }
        }
        // A[start... right]
        quickSort(A, start, right);
        // A[left ... end]
        quickSort(A, left, end);
    }
}