package Amazon.FirstBadVersion;

/*
 * https://www.jiuzhang.com/solutions/first-bad-version/
 * 第一个错误的代码版本
 * */
class GitRepo {
    public static boolean isBadVersion(int k) {
        return false;
    }
}

public class Solution {
    public int findFirstBadVersion(int n) {
        if (n == 1) return 1;
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (GitRepo.isBadVersion(mid)) {
                if (mid == 0 || !GitRepo.isBadVersion(mid - 1)) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
