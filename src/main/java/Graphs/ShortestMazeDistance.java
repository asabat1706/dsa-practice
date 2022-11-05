//package Graphs;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class ShortestMazeDistance {
//    public static void main(String[] args) {
//        int[][] maze = {{1, 1, 0, 1}, {0, 0, 0, 1}, {1, 0, 0, 1}, {0, 0, 1, 0}};
//        int[] source = {1, 1};
//        int[] destination = {2, 1};
//
//        Queue<MazeBlock> queue = new LinkedList<>();
//        MazeBlock source_block = new MazeBlock(source[0], source[1], 'A', 'A', 0);
//        MazeBlock rightBlock = new MazeBlock(source_block.row, source_block.col+1, 'L', 'R', 1);
//        if(isValidBlock(rightBlock,maze)){
//            queue.add(rightBlock);
//        }
//        MazeBlock leftBlock = new MazeBlock(source_block.row, source_block.col-1, 'R', 'L', 1);
//        if(isValidBlock(leftBlock,maze)){
//            queue.add(leftBlock);
//        }
//        MazeBlock upBlock = new MazeBlock(source_block.row-1, source_block.col, 'D', 'U', 1);
//        if(isValidBlock(leftBlock,maze)){
//            queue.add(leftBlock);
//        }
//        MazeBlock downBlock = new MazeBlock(source_block.row+1, source_block.col, 'U', 'D', 1);
//        if(isValidBlock(downBlock,maze)){
//            queue.add(downBlock);
//        }
//
//        int min_dist = Integer.MAX_VALUE;
//        while(!queue.isEmpty()) {
//            MazeBlock curr_block = queue.poll();
//            if(curr_block.isDestination() && isBallStopped(curr_block)){
//                min_dist = Math.min(min_dist, curr_block.dist);
//            }
//        }
//    }
//
//    private static boolean isBallStopped(MazeBlock right_block) {
//        return false;
//    }
//
//    private static boolean isValidBlock(MazeBlock curr_block, int[][] maze) {
//        return true;
//    }
//
//
//}
//class MazeBlock{
//    int row;
//    int col;
//    boolean left_visited=false;
//    boolean right_visited=false;
//    boolean top_visited=false;
//    boolean down_visited=false;
//    char next_direction;
//    char curr_direction;
//    int dist;
//
//    public MazeBlock(int row, int col, char curr_direction, char next_direction, int dist){
//        this.row = row;
//        this.col = col;
//        this.dist = dist;
//    }
//
//    public String toString(){
//        return "row: "+ row + " col: "+ col + " with dist "+ dist;
//    }
//}