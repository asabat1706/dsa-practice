package Graphs;
import java.util.*;

public class ConnectedIslands {
    static ArrayList<LinkedList<NodeIsland>> adjacencyList = new ArrayList<>();
    static boolean[] visited;
    static int mod = 1000000007;
    public static void main(String[] args){
        int nodes = 3;
        int[][] edges = {{1,2,20},{2,3,17}};
        createAdjacencyList(nodes, edges);
//        System.out.println(adjacencyList);
        visited = new boolean[nodes+1];
        visited[0] = true;
        int min_cost = calculateMinCost(1);
        System.out.println(min_cost);
    }

    private static int calculateMinCost(int node) {
        int min_cost = 0;
        visited[node]=true;
        PriorityQueue<NodeIsland> queue = new PriorityQueue<>((i1,i2)-> i1.cost<i2.cost?-1:1);
        LinkedList<NodeIsland> adjacent_nodes = adjacencyList.get(node);
        for(int i=0; i<adjacent_nodes.size(); i++){
            NodeIsland adj_node = adjacent_nodes.get(i);
            if(!visited[adj_node.vertex]){
                queue.add(adj_node);
            }
        }
        while(!queue.isEmpty()){
            NodeIsland nextNode = queue.poll();
            if(!visited[nextNode.vertex]){
                min_cost = ((min_cost%mod) + (nextNode.cost%mod))%mod;
            }
            adjacent_nodes = adjacencyList.get(nextNode.vertex);
            for(int i=0; i<adjacent_nodes.size(); i++){
                NodeIsland adj_node = adjacent_nodes.get(i);
                if(!visited[adj_node.vertex]){
                    queue.add(adj_node);
                }
            }
            visited[nextNode.vertex]=true;
        }

        return min_cost;
    }

    private static void createAdjacencyList(int nodes, int[][] edges) {
        LinkedList<NodeIsland> list = null;
        for(int i=0; i<= nodes; i++){
            list = new LinkedList<>();
            adjacencyList.add(list);
        }
        for(int i=0; i<edges.length; i++){
            LinkedList<NodeIsland> edge = adjacencyList.get(edges[i][0]);
            NodeIsland node = new NodeIsland(edges[i][1],edges[i][2]);
            edge.add(node);
            adjacencyList.set(edges[i][0],edge);
        }
        for(int i=0; i<edges.length; i++){
            LinkedList<NodeIsland> edge = adjacencyList.get(edges[i][1]);
            NodeIsland node = new NodeIsland(edges[i][0],edges[i][2]);
            edge.add(node);
            adjacencyList.set(edges[i][1],edge);
        }
    }
}

class NodeIsland{
    int vertex;
    int cost;
    public NodeIsland(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
    public String toString(){
        return "Node : "+this.vertex +" cost "+this.cost;
    }
}
