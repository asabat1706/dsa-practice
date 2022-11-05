package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class DirectedPath {
    static ArrayList<LinkedList<Integer>> adjacencyList = new ArrayList<>();
    public static void main(String[] args){
        int[] edges = {1,1,2};
        int source = 1;
        int destination = 1;
        createAdjacencyList(edges,edges.length);
        System.out.println(adjacencyList);
        boolean isExists = isPathExist(source,destination,edges);
        System.out.println(isExists);
    }

    private static boolean isPathExist(int source, int destination, int[] edges) {
        if(destination == source){
            return true;
        }
        LinkedList<Integer> edge = adjacencyList.get(source);
        for(int i=0; i<edge.size(); i++){
           boolean path =  isPathExist(edge.get(i),destination,edges);
           if(path){
               return true;
           }
        }
        return false;
    }

    private static void createAdjacencyList(int[] edges, int length) {
        LinkedList<Integer> list;
        for(int i=0; i<=length; i++){
            list = new LinkedList<>();
            adjacencyList.add(list);
        }
        for(int i=1; i<length; i++){
           LinkedList<Integer> edge = adjacencyList.get(edges[i]);
           edge.add(i+1);
           adjacencyList.set(edges[i],edge);
        }
    }
}
