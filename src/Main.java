import java.util.ArrayList;

class Graph{

    private ArrayList<Node> noduri;
    private ArrayList<Edge> muchii;

    private int visited[];
    Stack s;

    public Graph(){
        noduri=new ArrayList<Node>();
        muchii=new ArrayList<Edge>();
    }

    public void AddNode(int x, int y,  int value){
        Node newNode = new Node();
        newNode.x = x;
        newNode.y = y;
        newNode.Value = value;
        noduri.add(newNode);
    }
    public boolean AddEdge(int IndexNode1, int IndexNode2){
        if(IndexNode1==IndexNode2)
            return false;
        for(Edge edge:muchii)
        {
            if(edge.IndexNode1 == IndexNode1 && edge.Index2Node2 == IndexNode2)
                return false;
        }
        Edge edge = new Edge();
        edge.IndexNode1 = IndexNode1;
        edge.Index2Node2 = IndexNode2;
        muchii.add(edge);
        return true;
    }
    public int GetNodesCount(){
        return noduri.size();
    }
    public int GetEdgesCount(){
        return muchii.size();
    }

    public Node GetNode(int index){
        return noduri.get(index);
    }

    public boolean isConex() {
        DFS(0);
        System.out.println();
        for(int i=0;i<noduri.size();i++)
            if(visited[i]==0)
                return false;
        return true;
    }

    public void displayEdge(){
        for(Edge edge:muchii)
        {
            System.out.println(edge.IndexNode1 + " | " +edge.Index2Node2);
        }
    }

    public void DFS(int v){
        visited = new int[noduri.size()];
        for(int i = 0 ;i<noduri.size();i++)
            visited[i]=0;
        s = new Stack(noduri.size());
        DFSUtil(v);
    }

    private void DFSUtil(int v){
        visited[v]=1;
        System.out.print(v+ "  ");
        s.push(v);
        for(Edge e: muchii)
        {
            if (e.IndexNode1 == s.top()&& visited[e.Index2Node2]==0)
            {
                int n = e.Index2Node2;
                DFSUtil(n);
            }
            else if(e.Index2Node2 == s.top() && visited[e.IndexNode1]==0)
            {
                int n = e.IndexNode1;
                DFSUtil(n);
            }
        }
        s.pop();
    }
}

public class Main {

    public static void main(String[] args) {
        Graph g=new Graph();
        g.AddNode(10,10,100);
        g.AddNode(10,20,200);
        g.AddNode(20,20,300);
        g.AddNode(20,30,400);
        g.AddNode(35,35,500);
        g.AddNode(45,45,600);
        g.AddEdge(0, 1);
        g.AddEdge(1, 2);
        g.AddEdge(0,3);
        g.AddEdge(2,4);
        g.AddEdge(2,5);
        g.AddEdge(5,3);
        g.AddNode(100,100,900);
        g.AddNode(200,200,1000);
        g.AddEdge(6,7);
        System.out.printf("Node 1 value is %d \n",g.GetNode(1).Value);
        System.out.printf("Nodes = %d, Edges=%d, Conex=%b\n", g.GetNodesCount(), g.GetEdgesCount(), g.isConex());

    }
}

class Node{
    public int x;
    public int y;
    public int Value;
}

class Edge{
    public int IndexNode1;
    public int Index2Node2;
}
