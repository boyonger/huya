package graph.wholeGraph;

import java.io.IOException;

//邻接矩阵 无向图  //权值0表示无限
class Graph {
    private int graphMatrix[][];
    private int vertex[];

    public Graph(int verNumber) {
        graphMatrix = new int[verNumber][verNumber];
        for (int i = 0; i < graphMatrix.length; i++) {
            for (int j = 0; j < graphMatrix[0].length; j++) {
                if (i == j) graphMatrix[i][j] = 0;
                else {
                    graphMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        vertex = new int[verNumber];
    }

    public boolean addVertex(int v1, int v2, int weight) {
        if (v1 < 0 || v1 >= vertex.length || v1 < 0 || v2 >= vertex.length)
            return false;
        graphMatrix[v1][v2] = weight;
        graphMatrix[v2][v1] = weight;
        return true;
    }

    public boolean removeVertex(int v1, int v2) {
        if (v1 < 0 || v1 >= vertex.length || v1 < 0 || v2 >= vertex.length)
            return false;
        graphMatrix[v1][v2] = Integer.MAX_VALUE;
        graphMatrix[v2][v1] = Integer.MAX_VALUE;
        return true;
    }

    public int getFirstVertex(int v) {
        for (int i = 0; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v][i] > 0 && graphMatrix[v][i] < Integer.MAX_VALUE)
                return i;
        }
        return -1;
    }

    public int getNextVertex(int v1, int v2) {
        for (int i = v2 + 1; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v1][i] > 0 && graphMatrix[v1][i] < Integer.MAX_VALUE)
                return i;
        }
        return -1;
    }

    public int[] distanceMin(int v) {
        int vertexNumber = this.vertex.length;
        int dis[] = new int[vertexNumber];
        int vIn[] = new int[vertexNumber];
        vIn[v] = 1;
        dis[v] = 0;
        for (int i = 0; i < dis.length; i++) {
            dis[i] = graphMatrix[v][i];
        }
        for (int i = 0; i < vertexNumber - 1; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                if (dis[j] < Integer.MAX_VALUE) {
                    if (vIn[j] == 0) {
                        vIn[j] = 1;
                        for (int t = 0; t < vertexNumber; t++) {
                            dis[t] = Integer.min(dis[j] + graphMatrix[j][t], dis[t]);
                        }
                    }
                }
            }
        }
        return dis;
    }
}

public class GraphMatrix {
    public static void main(String[] args) throws IOException {

    }
}


