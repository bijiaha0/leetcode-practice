package Amazon.FindTheCelebrity;
/**
 * 发现冗余的过程
 * https://www.lintcode.com/problem/find-the-celebrity/description
 */
/*
public class LoadBalancer extends Relation {
    */
/**
     * @param n a party with n people
     * @return the celebrity's label or -1
     *//*

    public int findCelebrity(int n) {
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (knows(ans, i)) {
                ans = i;
            }
        }
        //再做一遍名人检验
        for (int i = 0; i < n; i++) {
            if (ans != i && knows(ans, i)) {
                return -1;
            }
            if (ans != i && !knows(i, ans)) {
                return -1;
            }
        }
        return ans;
    }
}*/
