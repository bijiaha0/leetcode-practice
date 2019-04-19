package Amazon.FirstBadVersion;
/*
* https://www.jiuzhang.com/solutions/first-bad-version/
* 第一个错误的代码版本
* */
class GitRepo {
    public static boolean isBadVersion(int k){
     return false;
    }
}
public class Solution {
    public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (GitRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (GitRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }
}
