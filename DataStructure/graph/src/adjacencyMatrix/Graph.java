package adjacencyMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//邻接矩阵表示图
public class Graph {
    private ArrayList<String> vertexList;//顶点集合
    private int[][] Edges;//表示边的矩阵
    private int numOfEdge;
    private boolean[] isVisited;//表示顶点是否已访问过

    public Graph(int n) {
        vertexList = new ArrayList<String>(n);
        Edges = new int[n][n];
        numOfEdge = 0;
    }

    //插入顶点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //插入边
    public void insertEdge(int n, int m, int weight) {
        Edges[n][m] = weight;
        Edges[m][n] = weight;
        numOfEdge++;
    }

    //得到第一个邻接点的下标
    public int getFirstNeighbor(int vertex) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (Edges[vertex][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    //得到上一个顶点的下一个邻接点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (Edges[v1][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历
    public void DFS(boolean[] isVisited, int i) {
        //访问当前节点
        System.out.print(vertexList.get(i) + "->");
        isVisited[i] = true;
        //找到第一个邻接点
        int neighbor = getFirstNeighbor(i);
        while (neighbor != -1) {
            if (!isVisited[neighbor]) {//未访问过，递归访问
                DFS(isVisited, neighbor);
            } else {//已访问过，继续找下一个邻接点
                neighbor = getNextNeighbor(i, neighbor);
            }
        }
    }

    //处理非连通图的情况
    public void DFS() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                DFS(isVisited, i);
            }
        }
        System.out.println();
    }

    //广度优先遍历
    public void BFS(boolean[] isVisited, int i) {
        //1.访问当前节点，标记当前节点为已访问
        System.out.print(vertexList.get(i) + "->");
        isVisited[i] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        //2.当前节点进队列，队列中是访问节点的顺序
        queue.addLast(i);
        int head;//队列首节点
        int neighbor;//邻接节点
        //3.当队列不为空，算法继续执行
        while (!queue.isEmpty()) {
            //4.取队列首元素
            head = queue.removeFirst();
            //5.取队列首元素的第一个邻接节点
            neighbor = getFirstNeighbor(head);
            //6.若未找到，跳转3，处理下一个节点，否则循环执行以下三步
            while (neighbor != -1) {
                if (!isVisited[neighbor]) {
                    //6.1若未访问，则访问
                    System.out.print(vertexList.get(neighbor) + "->");
                    isVisited[neighbor] = true;
                    //6.2将其加入队列
                    queue.addLast(neighbor);
                }
                //6.3继续找head的下一个邻接节点，这里体现了广度优先
                neighbor = getNextNeighbor(head, neighbor);
            }
        }
    }

    //对所有节点进行广度优先遍历
    public void BFS() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                BFS(isVisited, i);
            }
        }
        System.out.println();
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdge() {
        return numOfEdge;
    }

    public String getVertex(int i) {
        return vertexList.get(i);
    }

    public void show() {
        for (int[] edge : Edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
}
