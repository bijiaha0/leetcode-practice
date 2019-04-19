import java.util.Stack;

/**
 * Author: bijiaha0
 * Date: 2019-02-13
 * Time: 10:01 PM
 * Email: clickgwas@gmail.com
 */
public class JiQiRen {
    public static Stack<Integer> stack = null;
    public static int result = 0;
    //用来标记已经走过
    public static char used = 'u';
    public static void main(String[] args) {
        stack = new Stack<>();
        char[][] arr = {{'x',' ',' ', ' ',' '},{'x','x','x',' ','x'},{'x','x','x','x','x'}};
        fun(arr, 0, 0, 'x');
        System.out.println(result);
    }

    public static void fun(char[][] arr, int x, int y, char c) {
        int m = arr.length;
        int n =arr[0].length;
        // 遍历上下左右
        if (x - 1 >= 0 && y >= 0 && arr[x - 1][y] == 'x') {
            stack.push((x-1)*100+y);
            arr[x - 1][y] = used;
            result++;
        }
        if (x + 1 < m && y >= 0 && arr[x + 1][y] == 'x') {
            stack.push((x+1)*100+y);
            arr[x + 1][y] = used;
            result++;
        }
        if (x >= 0 && y - 1 >= 0 && arr[x][y - 1] == 'x') {
            stack.push(x*100+(y-1));
            arr[x][y - 1] = used;
            result++;
        }
        if (x >= 0 && y + 1 < n && arr[x][y + 1] == 'x') {    stack.push(x*100+(y+1));
            arr[x][y + 1] = used;
            result++;
        }
        while (!stack.isEmpty()) {
            int size = stack.size();
            int poll = stack.pop();
            System.out.println(poll);
            fun(arr, poll/100, poll%100, 'x');
        }
    }
}
