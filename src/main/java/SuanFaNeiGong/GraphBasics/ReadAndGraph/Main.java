package SuanFaNeiGong.GraphBasics.ReadAndGraph;
import SuanFaNeiGong.GraphBasics.DenseGraph;
import SuanFaNeiGong.GraphBasics.ReadGraph;
import SuanFaNeiGong.GraphBasics.SparseGraph;
// 测试通过文件读取图的信息
public class Main {
    public static void main(String[] args) {
        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        System.out.println("test G1 in Sparse SuanFaNeiGong.GraphBasics.ChapterCompletedCode.SuanFaNeiGong.GraphBasics.BFSAndShortestPath.SuanFaNeiGong.GraphBasics.FindingAPath.SuanFaNeiGong.GraphBasics.DFSAndComponents.SuanFaNeiGong.GraphBasics.ReadAndGraph.Graph:");
        g1.show();
        System.out.println();
        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2 , filename );
        System.out.println("test G1 in Dense SuanFaNeiGong.GraphBasics.ChapterCompletedCode.SuanFaNeiGong.GraphBasics.BFSAndShortestPath.SuanFaNeiGong.GraphBasics.FindingAPath.SuanFaNeiGong.GraphBasics.DFSAndComponents.SuanFaNeiGong.GraphBasics.ReadAndGraph.Graph:");
        g2.show();
        System.out.println();
        // 使用两种图的存储方式读取testG2.txt文件
        filename = "testG2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename);
        System.out.println("test G2 in Sparse SuanFaNeiGong.GraphBasics.ChapterCompletedCode.SuanFaNeiGong.GraphBasics.BFSAndShortestPath.SuanFaNeiGong.GraphBasics.FindingAPath.SuanFaNeiGong.GraphBasics.DFSAndComponents.SuanFaNeiGong.GraphBasics.ReadAndGraph.Graph:");
        g3.show();
        System.out.println();
        DenseGraph g4 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename);
        System.out.println("test G2 in Dense SuanFaNeiGong.GraphBasics.ChapterCompletedCode.SuanFaNeiGong.GraphBasics.BFSAndShortestPath.SuanFaNeiGong.GraphBasics.FindingAPath.SuanFaNeiGong.GraphBasics.DFSAndComponents.SuanFaNeiGong.GraphBasics.ReadAndGraph.Graph:");
        g4.show();
    }
}
