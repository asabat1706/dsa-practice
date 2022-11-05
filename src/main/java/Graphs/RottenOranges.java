package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args){
        int[][] input = {{2, 1, 1, 0},{0, 1, 0, 1}};
//        int[][] input =  {{2, 0, 2, 2, 2, 0, 2, 1, 1, 0},
//                {0, 1, 2, 0, 2, 0, 0, 1, 0, 1},
//                {0, 1, 1, 1, 2, 0, 1, 1, 2, 1},
//                {2, 0, 2, 0, 1, 1, 2, 1, 0, 1},
//                {1, 0, 1, 1, 0, 1, 2, 0, 2, 2},
//                {0, 2, 1, 1, 2, 2, 0, 2, 1, 2},
//                {2, 1, 0, 2, 0, 0, 0, 0, 1, 1},
//                {2, 2, 0, 2, 2, 1, 1, 1, 2, 2}};
        int n = input.length;
        int m = input[0].length;
        int min_time=0;
        boolean[][] visited = new boolean[n][m];
        Queue<OrangeIndex> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(input[i][j] == 0){
                    visited[i][j]=true;
                }
                else if(input[i][j] == 2){
                    OrangeIndex o = new OrangeIndex(i,j,0);
                    queue.add(o);
                    visited[o.row][o.col] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            OrangeIndex o = queue.poll();
            if((o.col+1 < m) && (!visited[o.row][o.col+1])){
                OrangeIndex right_orange = new OrangeIndex(o.row,o.col+1,o.time+1);
                queue.add(right_orange);
                visited[o.row][o.col+1] = true;
            }
            if((o.col-1 >= 0) && (!visited[o.row][o.col-1])){
                OrangeIndex left_orange = new OrangeIndex(o.row,o.col-1,o.time+1);
                queue.add(left_orange);
                visited[o.row][o.col-1] = true;
            }
            if((o.row-1 >= 0) && (!visited[o.row-1][o.col])){
                OrangeIndex up_orange = new OrangeIndex(o.row-1,o.col,o.time+1);
                queue.add(up_orange);
                visited[o.row-1][o.col] = true;
            }
            if((o.row+1 < n) && (!visited[o.row+1][o.col])){
                OrangeIndex down_orange = new OrangeIndex(o.row+1,o.col,o.time+1);
                queue.add(down_orange);
                visited[o.row+1][o.col] = true;
            }
            min_time = Math.max(o.time,min_time);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m ; j++){
                if(!visited[i][j]){
                    min_time = -1;
                }
            }
        }
       System.out.println(min_time);
    }
}
class OrangeIndex{
    int row;
    int col;
    int time;
    public OrangeIndex(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
    public String toString(){
        return "orange in "+ row + "row "+ col +" col "+time + " time" ;
    }
}
