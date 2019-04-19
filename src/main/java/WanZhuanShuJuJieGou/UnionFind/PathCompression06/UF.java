package WanZhuanShuJuJieGou.UnionFind.PathCompression06;

public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
