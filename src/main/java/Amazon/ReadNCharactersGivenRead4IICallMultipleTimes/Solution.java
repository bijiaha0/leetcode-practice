package Amazon.ReadNCharactersGivenRead4IICallMultipleTimes;
/**
 * https://www.lintcode.com/problem/read-n-characters-given-read4-ii-call-multiple-times/description
 */
public class Solution {
    char[] buffer = new char[4];
    int head = 0, tail = 0;
    public int read4(char[] buffer){
        return 4;
    };
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            if (head == tail) {               //队列为空是   进队
                head = 0;
                tail = read4(buffer);         // enqueue
                if (tail == 0) {
                    break;
                }
            }
            while (i < n && head < tail) {    //队列不为空   出队
                buf[i++] = buffer[head++];    // dequeue
            }
        }
        return i;
    }
}
