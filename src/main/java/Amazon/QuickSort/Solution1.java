package Amazon.QuickSort;
public class Solution1 {
    //快速排序
    public void QuickSort(int a[], int left, int right) {
        if (left >= right) {
            return;
        }
            int center = partition(a, left, right);
            QuickSort(a, left, center - 1);//左半部分
            QuickSort(a, center + 1, right);//右半部分
    }
    //快排模板
    public int partition(int[] nums, int l, int r) {
        //初始化左右指针
        int left = l, right = r;
        int pivot = nums[left];
        //进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        //返还pivot点到数据里面
        nums[left] = pivot;
        return left;
    }
}
