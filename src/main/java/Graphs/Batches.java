package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Batches {
    static ArrayList<LinkedList<Integer>> adjacencyList= new ArrayList<>();
    static boolean[] visited ;
    public static void main(String[] args){
//        int nodes = 7;
//        int[] strength = {1, 6, 7, 2, 9, 4, 5};
//        int[][] edges = {{1,2},{2,3},{5,6},{5,7}};
//        int req_str = 12;
//        int selected_batches =0;
        int nodes = 5;
        int[] strength = {1,2,3,4,5};
        int[][] edges = {{1,5},{2,3}};
        int req_str = 6;
        int selected_batches =0;

        createAdjacencyList(nodes,edges);
//        System.out.println(adjacencyList);
        visited = new boolean[nodes+1];
        for(int i=1; i<= nodes; i++){
            if(!visited[i]){
                int batch_strength = findBatchString(i,strength);
                if(batch_strength >= req_str){
                    selected_batches++;
                }
            }
        }

        System.out.println(selected_batches);
    }

    private static int findBatchString(int vertex, int[] strength) {
        int batch_str = 0;
        Queue<Integer> student_circle = new LinkedList<>();
        student_circle.add(vertex);

        while(!student_circle.isEmpty()){
            vertex = student_circle.poll();
            visited[vertex] = true;
            batch_str += strength[vertex-1];
            LinkedList<Integer> friends = adjacencyList.get(vertex);
            for(int i=0; i<friends.size(); i++){
                if(!visited[friends.get(i)]){
                    student_circle.add(friends.get(i));
                }
            }
        }

        return batch_str;
    }

    private static void createAdjacencyList(int nodes, int[][] edges) {
        for(int i=0; i<=nodes; i++){
            LinkedList<Integer> edge = new LinkedList<>();
            adjacencyList.add(edge);
        }
        for(int i=0; i<edges.length; i++){
            LinkedList<Integer> edge = adjacencyList.get(edges[i][0]);
            edge.add(edges[i][1]);
            adjacencyList.set(edges[i][0],edge);
        }
        for(int i=0; i<edges.length; i++){
            LinkedList<Integer> edge = adjacencyList.get(edges[i][1]);
            edge.add(edges[i][0]);
            adjacencyList.set(edges[i][1],edge);
        }
    }
}
