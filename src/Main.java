import java.util.ArrayList;

class Graph{

    private ArrayList<Node> noduri;
    private ArrayList<Edge> muchii;

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
        int nodAles = 0;
        int[] culori = new int[noduri.size()];
        for (int i = 0; i < noduri.size(); i++)
            culori[i] = -1;
        culori[nodAles] = 0;
        int k=0;
        while (nodAles<noduri.size()){
            for (Edge edge : muchii) {
                if (edge.IndexNode1 == nodAles && culori[edge.Index2Node2] == -1) {
                    culori[edge.Index2Node2] = 0;
                }
            }
            nodAles++;
    }
        for(int i=0;i<noduri.size();i++)
            if(culori[i]==-1)
                return false;
        return true;
    }

    public void displayEdge(){
        for(Edge edge:muchii)
        {
            System.out.println(edge.IndexNode1 + " | " +edge.Index2Node2);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Graph g=new Graph();
        g.AddNode(10,10,100);
        g.AddNode(10,20,200);
        g.AddNode(20,20,300);
        g.AddNode(20,30,400);
        g.AddEdge(0, 1);
        g.AddEdge(1, 2);
        g.AddEdge(0,3);
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
