package SuanFaNeiGong.GraphBasics.FindingAPath;

import SuanFaNeiGong.GraphBasics.Path;
import SuanFaNeiGong.GraphBasics.ReadGraph;
import SuanFaNeiGong.GraphBasics.SparseGraph;

public class Main {
    // 测试寻路算法
    public static void main(String[] args) {
        String filename = "testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("SuanFaNeiGong.GraphBasics.ChapterCompletedCode.SuanFaNeiGong.GraphBasics.BFSAndShortestPath.SuanFaNeiGong.GraphBasics.Path from 0 to 6 : ");
        path.showPath(6);
    }
}
