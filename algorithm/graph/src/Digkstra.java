import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Digkstra算法
 */
class Digkstra {
    static int[] minDict;
    static boolean[] visited;

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, List<Edge>> map = new HashMap<>();
        minDict = new int[n + 1];
        Arrays.fill(minDict, Integer.MAX_VALUE);
        minDict[1] = 0;
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(new Edge(s, t, w));
        }
        for (int i = 0; i < n; i++) {
            int minCost = Integer.MAX_VALUE;
            int minNode = -1;
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && minDict[j] < minCost) {
                    minCost = minDict[j];
                    minNode = j;
                }
            }
            if (minNode == -1) {
                break;
            }
            visited[minNode] = true;
            for (Edge edge : map.getOrDefault(minNode, new ArrayList<>())) {
                if (!visited[edge.to] && minDict[edge.to] > minDict[minNode] + edge.cost) {
                    minDict[edge.to] = minDict[minNode] + edge.cost;
                }
            }
        }
        System.out.println(minDict[n] == Integer.MAX_VALUE ? -1 : minDict[n]);
    }
}
