package tutor8.graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Graph extends TreeSet<Vertex> {
    public Graph() {
        super();
    }

    //Thêm đỉnh vào đồ thị
    public void addVertex(Vertex v){
        this.add(v);
    }

    //Truy xuất đỉnh với tên đỉnh đã biết
    Vertex get (String vertexName){
        Iterator iter = this.iterator();
        while (iter.hasNext()){
            Vertex v = (Vertex)(iter.next());
            if(v.name.equals(vertexName)){
                return v;
            }
        }
        return null;
    }
    //Thêm một cạnh với 2 tên đỉnh đã biết
    public boolean addEdge (String nameFrom, String nameTo){
        Vertex u = this.get(nameFrom); //Tìm 2 tham khảo đến 2 đỉnh
        Vertex v = this.get(nameTo);
        if (u == null || v == null){
            return false;
        }
        Edge e = new Edge(u, v, 1); //mặc định trọng số là 1
        u.adjList.add(e);
        return true;
    }

    //Thêm một cạnh với 2 tham khảo đỉnh đã biết
    public boolean addEdge (Vertex u, Vertex v){
        if( u == null || v == null){
            return false;
        }
        Edge e = new Edge(u, v, 1);
        u.adjList.add(e);
        return true;
    }
    //Thêm cạnh có trọng số
    public boolean addEdge (String nameFrom, String nameTo, double w){
        Vertex u = this.get(nameFrom); //Tìm 2 tham khảo đến 2 đỉnh
        Vertex v = this.get(nameTo);
        if (u == null || v == null){
            return false;
        }
        Edge e = new Edge(u, v, w); //mặc định trọng số là 1
        u.adjList.add(e);
        return true;
    }
    public boolean addEdge (Vertex u, Vertex v, double w){
        if( u == null || v == null){
            return false;
        }
        Edge e = new Edge(u, v, w);
        u.adjList.add(e);
        return true;
    }

    public Graph loadFromFile1 (String fName){
        Graph g = null;
        File f = new File(fName);
        if(!f.exists()){
            System.out.println("File not found.");
            System.exit(0);
            return g;
        }
        try{
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line = null;
            StringTokenizer stringTokenizer = null;
            //Lấy tên các đỉnh
            line = bf.readLine();
            if( line != null){
                g = new Graph(); // tạo đồ thị
                //cắt chuỗi để lấy tên các đỉnh dựa vào khoảng trắng
                stringTokenizer = new StringTokenizer(line, " ");
                while (stringTokenizer.hasMoreTokens()){
                    String name = stringTokenizer.nextToken();
                    Vertex v = new Vertex(name);
                    g.add(v);
                }
            }
            //Lấy các danh sách kề
            while ((line = bf.readLine()) != null){
                stringTokenizer = new StringTokenizer(line, " ");
                //lấy đỉnh nguồn
                String nameFrom = stringTokenizer.nextToken();
                Vertex u = g.get(nameFrom);
                //Tạo danh sách kề cho đỉnh này
                while(stringTokenizer.hasMoreTokens()){
                    String nameTo = stringTokenizer.nextToken();
                    Vertex v = g.get(nameTo);
                    g.addEdge(u,v);
                }

            }

            bf.close(); fr.close();//DONG FILE

        }catch (Exception e){
            g=null;
        }
        return g;
    }

    //Xuất đồ thị

    @Override
    public String toString() {
        String S = "Empty graph";
        if( this == null || this.size() == 0){
            return S;
        }
        S = "Graph: \n";
        Iterator<Vertex> it_Vertex = this.iterator();
        while (it_Vertex.hasNext()){
            //lấy 1 đỉnh
            Vertex u = it_Vertex.next();
            S += u.getName() + "\t";
            Iterator<Edge> it_Edge = u.getAdjList().iterator();
            while (it_Edge.hasNext()){
                Edge e = it_Edge.next();
                S += e.toString() + " ";
            }
            S += "\n";
        }
        return S;
    }
    //Duyệt đỉnh u với thứ tự đang có order, tập cạnh kết quả edge
    protected int DFS (Vertex u, int order, ArrayList<Edge> edges){
        int newOrder = order + 1;
        u.setNum(order);
        //Lấy danh sách đỉnh kề
        Iterator<Edge> it = u.getAdjList().iterator();
        while (it.hasNext()){
            Edge e = it.next();
            Vertex v = e.getV();
            if(v.num == 0){ //nếu đỉnh tới chưa được duyệt
                edges.add(e);
                newOrder = DFS(v, newOrder, edges);
            }
        }
        return newOrder;
    }

    //Duyệt Depth First Search
    public ArrayList<Edge> depthFirstSearch(){
        ArrayList result = new ArrayList<Edge>();
        //Đánh dấu chưa duyệt cho tập đỉnh
        Object [] vertices = this.toArray();
        for(int i = 0; i < vertices.length; i++){
            Vertex v = (Vertex) vertices[i];
            v.num = 0;
        }
        //Duyệt DFS cho tập đỉnh
        Integer order = 1;
        for (int i = 0; i < vertices.length; i++){
            Vertex v = (Vertex) vertices[i];
            if( v.num == 0 ){
                order = DFS(v, order, result);
            }
        }
        return result.size() > 0 ? result : null;
    }

    //Xuất tập cạnh ra PrintWriter
    public void printEdges (ArrayList<Edge> edges, PrintStream printStream){
        if(edges == null || edges.isEmpty()){
            printStream.println("No edge.");
        }else{
            printStream.println("Set of edges: ");
            printStream.println(edges);
        }
    }
}
