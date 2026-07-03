package adjacencyMatrix;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertexs = {"A", "B", "C", "D", "E"};
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.show();
        System.out.println("深度优先：");
        graph.DFS();
        System.out.println("广度优先：");
        graph.BFS();
    }
}
