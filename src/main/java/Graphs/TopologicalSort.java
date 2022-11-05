package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TopologicalSort {
    static ArrayList<LinkedList<Integer>> adjacencyList = new ArrayList<>();
    static int[] dependencies;
    public static void main(String[] args){
        int nodes = 3;
        int edges[][] = {{1,2},{2,3},{3,1}};
        dependencies = new int[nodes+1];
        dependencies[0] = -1;
        createAdjacencyList(nodes,edges);
//        System.out.println(adjacencyList);
//        for(int i=0; i< dependencies.length; i++){
//            System.out.print(dependencies[i]+"  ");
//        }
        int[] topological_sort = new int[nodes];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<dependencies.length; i++){
            if(dependencies[i] == 0){
                queue.add(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
           int node = queue.remove();
           LinkedList<Integer> adj_edges = adjacencyList.get(node);
           for(int i=0; i<adj_edges.size(); i++){
               int adj_node = adj_edges.get(i);
               dependencies[adj_node]--;
               if(dependencies[adj_node] == 0){
                   queue.add(adj_node);
               }
           }
           topological_sort[index++] = node;
        }
        for(int i=0; i< topological_sort.length; i++){
            System.out.print(topological_sort[i]+"  ");
        }
    }

    private static void createAdjacencyList(int nodes, int[][] edges) {
        for(int i=0; i<=nodes; i++){
            LinkedList<Integer> edge= new LinkedList<>();
            adjacencyList.add(edge);
        }

        for(int i=0; i<edges.length; i++){
            LinkedList<Integer> edge = adjacencyList.get(edges[i][0]);
            edge.add(edges[i][1]);
            adjacencyList.set(edges[i][0],edge);
            dependencies[edges[i][1]]++;
        }
    }
}
