package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class CyclicGraph {
    static ArrayList<LinkedList<Integer>> adjacencyList = new ArrayList<>();
    static boolean[] isVisited; 
    public static void main(String[] args){
        int A = 5;
        int[][] B = {{1,2},{1,3},{2,3},{1,4},{4,5}};
        isVisited = new boolean[A+1];
        createAdjacencyList(B,A);
        boolean ans = isCyclicGraph(1,0);
        System.out.println(ans);
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

    private static boolean isCyclicGraph(int current_vertex, int parent_vertex) {
             isVisited[current_vertex] = true;
             LinkedList<Integer> list = adjacencyList.get(current_vertex);
             for(int j=0; j<list.size(); j++){
                if(list.get(j) != parent_vertex && isVisited[list.get(j)]){
                    return true;
                }
                if(!isVisited[list.get(j)]) {
                     return isCyclicGraph(list.get(j), current_vertex);
                }
             }
        return false;
    }
}
