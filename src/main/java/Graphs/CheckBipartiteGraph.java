package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartiteGraph {
    static ArrayList<LinkedList<ColorNode>> adjacencyList = new ArrayList<>();
    static int[] colors;
    public static void main(String[] args){
        int nodes = 2;
        int[][] edges = {{0,1}};
        createAdjacencyList(nodes,edges);
        colors = new int[nodes];
        boolean ans = true;
        for(int i=0; i< nodes; i++){
            if(colors[i] == 0){
                boolean b = colorGraph(i,1);
                if(!b){
                    ans = false;
                    break;
                }
            }
        }
        System.out.println(ans);

    }

    private static boolean colorGraph(int source, int color) {
        Queue<ColorNode> queue = new LinkedList<>();
        queue.add(new ColorNode(source,color));
        while(!queue.isEmpty()){
            ColorNode node = queue.poll();
            colors[node.vertex] = node.color;
            LinkedList<ColorNode> adjacent_vertices = adjacencyList.get(node.vertex);
            for(int i=0; i<adjacent_vertices.size(); i++){
                ColorNode adj_node = adjacent_vertices.get(i);
                if(adj_node.color == node.color){
                    return false;
                }
                if(adj_node.color == 0){
                   if(node.color == 1){
                       adj_node.color = 2;
                   }
                   else{
                       adj_node.color = 1;
                   }
                    queue.add(adj_node);
                }
            }
        }
        return true;
    }

    private static void createAdjacencyList(int nodes, int[][] edges) {
        for(int i=0; i<nodes; i++){
            LinkedList<ColorNode> list = new LinkedList<>();
            adjacencyList.add(list);
        }
        for(int i=0; i< edges.length; i++){
            LinkedList<ColorNode> edge = adjacencyList.get(edges[i][0]);
            ColorNode adj_vertex = new ColorNode(edges[i][1],0);
            edge.add(adj_vertex);
            adjacencyList.set(edges[i][0],edge);
        }
        for(int i=0; i< edges.length; i++){
            LinkedList<ColorNode> edge = adjacencyList.get(edges[i][1]);
            ColorNode adj_vertex = new ColorNode(edges[i][0],0);
            edge.add(adj_vertex);
            adjacencyList.set(edges[i][1],edge);
        }
    }
}
class ColorNode{
    int vertex;
    int color;

    public ColorNode(int vertex, int color){
        this.color = color;
        this.vertex = vertex;
    }

    public String toString(){
        return "vertex "+ vertex + " has color "+color;
    }
}