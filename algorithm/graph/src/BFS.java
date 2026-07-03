import java.util.*;

/**
 * 广度优先遍历：岛屿数量
 */
class BFS {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    count++;
                    bfs(i, j, map);
                }
            }
        }
        System.out.println(count);
    }

    private static void bfs(int i, int j, int[][] map) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        map[i][j] = 0;
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                i = poll[0] + dir[0];
                j = poll[1] + dir[1];
                if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] != 1) {
                    continue;
                }
                map[i][j] = 0;
                queue.offer(new int[]{i, j});
            }
        }
    }
}