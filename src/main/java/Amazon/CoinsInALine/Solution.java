package Amazon.CoinsInALine;
/*
* https://www.jiuzhang.com/solution/coins-in-a-line/
* 当硬币数目是3的倍数的时候, 先手玩家必败, 否则他必胜.
* */
public class Solution {
    public boolean firstWillWin(int n) {
        if (n % 3 != 0)
            return true;
        else
            return false;
    }
}
