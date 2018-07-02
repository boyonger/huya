package graph;

//邻接表无向图
public class GraphLink {

    private class Edge {
        int vexNumber; //指后一个顶点
        int weight; //权值
        Edge nextEdge;

        public Edge() {

        }

        public Edge(int vexNumber, int weight) {
            this.vexNumber = vexNumber;
            this.weight = weight;
            this.nextEdge = null;
        }
    }

    private class Vertex {
        char data; //顶点定义，如顶点名字
        Edge firstEdge;

        public Vertex() {

        }

        public Vertex(char data) {
            this.data = data;
            this.firstEdge = null;
        }
    }

    private Vertex[] mVertex;

    //构造函数，编号从0开始
    public GraphLink(int number, int edge[][]) {
        mVertex = new Vertex[number];
        for (int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            int weight=0;
            this.insertEdge(v1,v2,weight);
        }

    }

    public boolean insertEdge(int v1, int v2, int weight) {
        if (v1 >= mVertex.length || v2 >= mVertex.length) return false;
        Edge p = mVertex[v1].firstEdge;
        while (p != null) {
            if (p.vexNumber == v2) return false;
            p = p.nextEdge;
        }
        p = new Edge(v2, weight);
        //头插法,每次都会插入两个，判断一次即可
        p.nextEdge=mVertex[v1].firstEdge;
        mVertex[v1].firstEdge=p;

        Edge q=new Edge(v1,weight);
        q.nextEdge=mVertex[v2].firstEdge;
        mVertex[v2].firstEdge=q;

        return true;
    }


}
