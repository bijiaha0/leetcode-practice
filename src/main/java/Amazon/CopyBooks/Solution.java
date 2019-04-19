package Amazon.CopyBooks;
/*
*https://www.lintcode.com/problem/copy-books/description
* https://www.jiuzhang.com/solution/copy-books/
* 给出一个数组A包含n个元素，表示n本书以及各自的页数。
* 现在有k个人复印书籍，每个人只能复印连续一段编号的书，
* 比如A[1],A[2]由第一个人复印，但是不能A[1],A[3]由第一个人复印，
* 求最少需要的时间复印所有书。
* 二分
* */
public class Solution {
    public int copyBooks(int[] pages, int k) {
        int l = 0;
        int r = Integer.MAX_VALUE;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (check(pages, mid, k)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (check(pages, l, k)) {
            return l;
        }
        return r;
    }

    private boolean check(int[] pages, int limit, int k) {
        int num = 0;
        int left = 0;
        for (int item : pages) {
            if (item > limit) {//limit表示最慢的复印员的页数
                return false;
            }
            if (item > left) {//让别人代劳
                num++;
                left = limit;
            }
            left -= item;//自己换可以承担
        }
        return num <= k;
    }
}

