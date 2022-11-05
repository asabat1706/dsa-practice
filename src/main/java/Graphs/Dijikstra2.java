package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijikstra2 {
    static int[] min_dist;
    static ArrayList<LinkedList<DijikstraNode>> adjacencyList= new ArrayList<>();
    public static void main(String[] args){
        int nodes = 6;
        int[][] edges = {{0,4,9},{3,4,6},{1,2,1},{2,5,1},
                {2,4,5},{0,3,7},{0,1,1},{4,5,7},{0,5,1}};
        int source = 4;
        min_dist = new int[nodes];
        for(int i=0; i<nodes; i++){
            if(i != source) {
                min_dist[i] = Integer.MAX_VALUE;
            }
            else{
                min_dist[i] = 0;
            }
        }
        createWeightedAdjacencyList(edges,nodes);
        System.out.println(adjacencyList);
        PriorityQueue<DijikstraNode> minHeap = new PriorityQueue<>((n1,n2)-> Integer.compare(n1.weight, n2.weight));
        calculateMinDistance(minHeap,source);
        for(int i=0; i<min_dist.length; i++){
            System.out.print(min_dist[i]+"  ");
        }
    }

    private static void calculateMinDistance(PriorityQueue<DijikstraNode> minHeap, int source) {
        LinkedList<DijikstraNode> edges = adjacencyList.get(source);
        for (DijikstraNode node : edges) {
            min_dist[node.vertex] = node.weight;
            minHeap.add(node);
        }
        while(!minHeap.isEmpty()){
            DijikstraNode node = minHeap.poll();
            if(node.weight <= min_dist[node.vertex]){
                LinkedList<DijikstraNode> connected_edges = adjacencyList.get(node.vertex);
                for(DijikstraNode connected_node: connected_edges){
                    int connected_dist = node.weight+ connected_node.weight;
                    if(min_dist[connected_node.vertex] > connected_dist){
                        min_dist[connected_node.vertex] = connected_dist;
                        DijikstraNode new_node = new DijikstraNode(connected_node.vertex,connected_dist);
                        minHeap.add(new_node);
                    }
                }
            }
        }
    }

    private static void createWeightedAdjacencyList(int[][] edges, int nodes) {
        for(int i=0; i<nodes; i++){
            LinkedList<DijikstraNode> edge= new LinkedList<>();
            adjacencyList.add(edge);
        }
        for(int i=0; i<edges.length; i++){
            LinkedList<DijikstraNode> edge = adjacencyList.get(edges[i][0]);
            DijikstraNode node_values = new DijikstraNode(edges[i][1],edges[i][2]);
            edge.add(node_values);
            adjacencyList.set(edges[i][0],edge);
        }
        for(int i=0; i<edges.length; i++){
            LinkedList<DijikstraNode> edge = adjacencyList.get(edges[i][1]);
            DijikstraNode node_values = new DijikstraNode(edges[i][0],edges[i][2]);
            edge.add(node_values);
            adjacencyList.set(edges[i][1],edge);
        }
    }

}
class DijikstraNode{
    int vertex;
    int weight;

    public DijikstraNode(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }

    public String toString(){
        return "Node: "+ vertex +" weight: "+weight;
    }
}
