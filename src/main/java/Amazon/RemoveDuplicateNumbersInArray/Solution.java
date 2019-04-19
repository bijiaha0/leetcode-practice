package Amazon.RemoveDuplicateNumbersInArray;
import java.util.HashMap;
import java.util.Map;
/**
 * https://www.jiuzhang.com/solution/remove-duplicate-numbers-in-array/
 * 给一个整数数组，去除重复的元素。
 * 你应该做这些事
 * 1.在原数组上操作
 * 2.将去除重复之后的元素放在数组的开头
 * 3.返回去除重复元素之后的元素个数
 */
public class Solution {
    public int deduplication(int[] nums) {

        HashMap<Integer, Boolean> mp = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; ++i)
            mp.put(nums[i], true);

        int result = 0;
        for (Map.Entry<Integer, Boolean> entry : mp.entrySet())
            nums[result++] = entry.getKey();
        return result;
    }
}
