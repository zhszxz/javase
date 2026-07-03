import java.util.*;

/**
 * Bellman-Ford算法
 */
class BellmanFord {
    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            List<Edge> list = graph.computeIfAbsent(s, ArrayList::new);
            list.add(new Edge(t, w));
        }
        int[] minDict = new int[n + 1];
        Arrays.fill(minDict, Integer.MAX_VALUE);
        minDict[1] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            Integer i = queue.removeFirst();
            visited[i] = false;
            for (Edge edge : graph.getOrDefault(i, new ArrayList<>())) {
                minDict[edge.to] = Math.min(minDict[edge.to], minDict[i] + edge.cost);
                if (visited[edge.to] == false) {
                    queue.addLast(edge.to);
                    visited[edge.to] = true;
                }
            }
        }
        System.out.println(minDict[n] == Integer.MAX_VALUE ? "unconnected" : minDict[n]);
    }
}
