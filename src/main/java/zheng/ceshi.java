package zheng;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。
 迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。迷宫之中有的路上还有门，
 每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。
 请设计一个算法，帮助探险家找到脱困的最短路径。如前所述，迷宫是通过一个二维矩阵表示的，
 每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，
 大写字母-门，小写字母-对应大写字母所代表的门的钥匙
 */
class Node {
    int x;
    int y;
    int keys;
    int deep;

    public Node(int x, int y, int keys, int deep) {
        super();
        this.x = x;
        this.y = y;
        this.keys = keys;
        this.deep = deep;
    }
}

public class ceshi {
    /*
    * next()从遇到第一个有效字符（非空格、换行符）开始扫描，遇到第一个分隔符或结束符（空格’ ‘或者换行符 ‘\n’）时结束。
    * nextLine()则是扫描剩下的所有字符串知道遇到回车为止。
    * */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        scan.nextLine();
        /*char A[][] = new char[m][n];
        for (int i = 0; i < m; ++i) {
            String s = scan.nextLine();
            for (int j = 0; j < n; ++j) {
                A[i][j] = s.charAt(j);
            }
        }*/
        System.out.println(m);
    }


    // maze迷宫，isVisited表示状态是否有过，有过就是true start开始结点
    public static int BFS(char[][] maze, boolean[][][] isVisited, Node start) {
        Queue<Node> queue = new LinkedList<>(); // bfs队列
        queue.add(start);
        isVisited[start.x][start.y][0] = true; // 用比特位来表示对应为门是否有要是
        // 'A'表示标号为0位的门是否有钥匙
        int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        Node now, next; // now 表示当前结点，next表示要进入队列的结点
        int M = maze.length;
        int N = maze[0].length;
        while (!queue.isEmpty()) {
            now = queue.poll();
            if (maze[now.x][now.y] == '3') {  // 如果该点是终点 结束
                return now.deep;
            }
            for (int i = 0; i < 4; i++) {
                //当前如果是钥匙，next.keys在下面的步骤会改变
                next = new Node(now.x + dirs[i][0], now.y + dirs[i][1], now.keys, now.deep+1);

                if (next.x < 0 || next.x >= M || next.y < 0 || next.y >= N
                        || maze[next.x][next.y] == '0') { //不能走就不进入队列
                    continue;
                }
                if (maze[next.x][next.y] <= 'Z' && maze[next.x][next.y] >= 'A'
                        &&(now.keys&(1<<(maze[next.x][next.y]-'A')))==0) {
                    continue;   //next结点为门，now没有对应钥匙就不走（next 不进队列）
                }
                if (maze[next.x][next.y] <= 'z' && maze[next.x][next.y] >= 'a') {
                    //是钥匙 就将next.keys重新赋值
                    next.keys=next.keys|1<<(maze[next.x][next.y]- 'a');
                }
                if (!isVisited[next.x][next.y][now.keys]) {
                    //next的状态没来过就标记
                    isVisited[next.x][next.y][now.keys]=true;
                    //next 进入队列
                    queue.add(next);
                }
            }
        }
        return -1;
    }
    public static void saoMiao(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(" ");
            int M = Integer.valueOf(strings[0]);
            int N = Integer.valueOf(strings[1]);
            char[][] maze = new char[M][N];
            Node start = new Node(0, 0, 0, 0);
            int gate=0;
            for (int i = 0; i < M; i++) {
                maze[i] = sc.nextLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    //找起点
                    if (maze[i][j] == '2') {
                        start.x = i;
                        start.y = j;
                    }
                    //统计一共多少门
                    if (maze[i][j] <= 'Z'&&maze[i][j] >= 'A') {
                        gate++;
                    }
                }
            }
            //所有状态的 访问情况
            boolean[][][]isVisited=new boolean[M][N][2<<gate];
            //只输出路径的步数（不包括起点）
            System.out.println(BFS(maze, isVisited, start));
        }
        sc.close();
    }
}


