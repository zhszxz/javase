import java.util.ArrayList;
import java.util.Scanner;

/**
 * KrusKal算法：最小生成树
 */
class KrusKal {

    static int[] father;

    static class Edge {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        init(v);
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            Edge edge = new Edge(s, t, w);
            edges.add(edge);
        }
        edges.sort((o1, o2) -> o1.w - o2.w);
        int totalWeight = edges.stream().filter(edge -> {
            if (!isConnected(edge.a, edge.b)) {
                join(edge.a, edge.b);
                return true;
            }
            return false;
        }).mapToInt(edge -> edge.w).sum();
        System.out.println(totalWeight);
    }

    private static void init(int v) {
        father = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            father[i] = i;
        }
    }

    private static int find(int v) {
        if (v != father[v]) {
            father[v] = find(father[v]);
        }
        return father[v];
    }

    private static void join(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fa] = fb;
        }
    }

    private static boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}
