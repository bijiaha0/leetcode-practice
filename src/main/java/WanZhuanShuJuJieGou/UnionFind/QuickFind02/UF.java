package WanZhuanShuJuJieGou.UnionFind.QuickFind02;

public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
