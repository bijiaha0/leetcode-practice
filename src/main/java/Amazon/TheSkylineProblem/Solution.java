package Amazon.TheSkylineProblem;

import java.util.*;
/*
*https://www.jiuzhang.com/solutions/the-skyline-problem/#tag-other
* */
public class Solution {
    /**
     */
    public class Point {
        int bldg;
        int x;
        int height;
        int status;

        public Point(int bldg, int x, int height, int status) {
            this.bldg = bldg;
            this.x = x;
            this.height = height;
            this.status = status;
        }
    }

    public class Height {
        int height;
        int bldg;

        public Height(int height, int bldg) {
            this.height = height;
            this.bldg = bldg;
        }
    }

    public List<List<Integer>> buildingOutline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings.length == 0) {
            return result;
        }

        //拆解每个建筑物为两个点，起点和终点，并存储到points中
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            points.add(new Point(i, b[0], b[2], 1));
            points.add(new Point(i, b[1], b[2], -1));
        }

        //对points进行排序，排序优先级为，横坐标>进入or离开>高度
        Collections.sort(points, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.x != b.x) {
                    return a.x - b.x;
                }
                if (a.status != b.status) {
                    return a.status - b.status;
                }
                return a.height - b.height;
            }
        });

        //使用TreeSet存储当前位置的建筑物高度，最高者即为当前区间的高度
        TreeSet<Height> ts = new TreeSet<>(new Comparator<Height>() {
            public int compare(Height a, Height b) {
                if (a.height == b.height) {
                    return a.bldg - b.bldg;
                }
                return a.height - b.height;
            }
        });

        //先向TreeSet中添加第一个点
        int curtX = points.get(0).x;
        int curtH = points.get(0).height;
        int curtB = points.get(0).bldg;
        ts.add(new Height(curtH, curtB));

        //循环所有之前拆解的点，找到区间并合并
        for (int i = 1; i < points.size(); i++) {
            Point p = points.get(i);
            int height = ts.isEmpty() ? 0 : ts.last().height;
            List<Integer> interval = new ArrayList<>();
            interval.add(curtX);
            interval.add(p.x);
            interval.add(height);
            mergeTo(result, interval);

            if (p.status == 1) {
                ts.add(new Height(p.height, p.bldg));
            }
            if (p.status == -1) {
                ts.remove(new Height(p.height, p.bldg));
            }

            curtX = p.x;
        }

        return result;
    }

    private void mergeTo(List<List<Integer>> result, List<Integer> interval) {
        if ((int)interval.get(0) == (int)interval.get(1) || interval.get(2) == 0) {
            return;
        }
        if (result.size() == 0) {
            result.add(interval);
            return;
        }

        List<Integer> prev = result.get(result.size() - 1);
        if ((int)prev.get(2) == (int)interval.get(2) && (int)prev.get(1) == (int)interval.get(0)) {
            prev.set(1, interval.get(1));
        } else {
            result.add(interval);
        }
    }
}
