package Advanced_Arrays;

public class ChristmasTree {
    public static void main(String[] args){
        int[] tree_height = {5, 9, 10, 4, 7, 8};
        int[] tree_cost = {5, 6, 4, 7, 2, 5};
        int min_cost = Integer.MAX_VALUE;
        for(int i=1; i<tree_height.length-1; i++){
            int small_tree_cost=Integer.MAX_VALUE;
            int larger_tree_cost=Integer.MAX_VALUE;
            for(int j= i-1; j>=0; j--){
                if(tree_height[j] < tree_height[i]){
                    small_tree_cost = Math.min(small_tree_cost,tree_cost[j]);
                }
            }
            for(int j= i+1; j<tree_height.length; j++){
                if(tree_height[j] > tree_height[i]){
                    larger_tree_cost = Math.min(larger_tree_cost,tree_cost[j]);
                }
            }
            if(small_tree_cost != Integer.MAX_VALUE && larger_tree_cost != Integer.MAX_VALUE) {
                int cost = tree_cost[i] + small_tree_cost + larger_tree_cost;
                min_cost = Math.min(cost, min_cost);
            }
        }
        System.out.println(min_cost);
    }
}
