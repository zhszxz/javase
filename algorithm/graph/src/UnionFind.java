/**
 * 并查集
 */
public class UnionFind {

    public static void main(String[] args) {
        // 1. 初始化并查集，管理0-4共5个元素
        UnionFind.init(5);

        // 2. 合并集合：1和2连通，3和4连通，2和3连通
        UnionFind.join(1, 2);
        UnionFind.join(3, 4);
        UnionFind.join(2, 3);

        // 3. 判断连通性
        System.out.println(UnionFind.isSame(1, 4));
        System.out.println(UnionFind.isSame(1, 5));
    }

    static int[] father;

    public static void init(int n) {
        father = new int[n + 1];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public static void join(int s, int t) {
        s = find(s);
        t = find(t);
        if (s == t) {
            return;
        }
        father[s] = t;
    }

    public static int find(int n) {
        if (n == father[n]) {
            return n;
        }
        return father[n] = find(father[n]);
    }

    public static boolean isSame(int s, int t) {
        return find(s) == find(t);
    }
}
