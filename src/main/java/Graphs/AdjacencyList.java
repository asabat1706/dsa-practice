package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
//Adjacency List Creation for undirected, unweighted graph
public class AdjacencyList {
    static ArrayList<LinkedList<Integer>> adjacencyList = new ArrayList<>();
    public static void main(String[] args){
        int nodes = 5;
        int[][] connections = {{1,2},{1,3},{2,3},{1,4},{4,5}};
         createAdjacencyList(connections,nodes);
        System.out.println(adjacencyList);
    }

    private static void createAdjacencyList(int[][] connections, int nodes) {
        LinkedList<Integer> edges;
        for (int i = 0; i <= nodes; i++) {
            edges = new LinkedList<>();
            adjacencyList.add(edges);
        }
        for (int node = 0; node < connections.length; node++) {
            edges = adjacencyList.get(connections[node][0]);
            edges.add(connections[node][1]);
            adjacencyList.set(connections[node][0], edges);
        }
        for (int node = 0; node < connections.length; node++) {
            edges = adjacencyList.get(connections[node][1]);
            edges.add(connections[node][0]);
            adjacencyList.set(connections[node][1], edges);
        }
    }

}
