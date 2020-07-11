package tutor8.graphs;

import java.util.TreeSet;

//Lop mo ta cho mot dinh trong do thi dung danh sach lien ke.
//Để danh sách đỉnh có thứ tự theo tên nên lớp này hiện thực interface Comparable
public class Vertex implements Comparable {
    String name;  //ten dinh
    TreeSet<Edge> adjList; //danh sach dinh ke cua dinh nay
    int num = 0; // bien flag duoc dung khi duyet do thi

    public Vertex() {
        name = null;
        adjList = new TreeSet<Edge>();
    }

    public Vertex(String name) {
        this.name = name;
        adjList = new TreeSet<Edge>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<Edge> getAdjList() {
        return adjList;
    }

    public void setAdjList(TreeSet<Edge> adjList) {
        this.adjList = adjList;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public int compareTo(Object o){
        return name.compareTo(((Vertex)o).name);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                '}';
    }
}

