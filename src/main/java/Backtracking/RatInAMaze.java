package Backtracking;

import java.util.ArrayList;

public class RatInAMaze {
    static int[][] ans_maze;
    public static void main(String[] args){
        int[][] maze =  {{1, 1, 1},
                {1, 0, 1},
                {0, 0, 1}};
        crossMaze(maze,0,0);
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++)
            {
                System.out.print(ans_maze[i][j]);
            }
            System.out.println();
        }
    }

    private static void crossMaze(int[][] maze, int row, int col) {
        if(row >= maze.length || col >= maze[0].length){
            return;
        }
        if((row == maze.length-1) && (col == maze[0].length-1)){
            ans_maze = new int[maze.length][maze[0].length];
            for(int i=0; i<maze.length; i++){
                for(int j=0; j<maze[0].length; j++){
                    ans_maze[i][j]= maze[i][j] ;
                }
            }
            return;
        }
        if(maze[row][col] == 0){
            return;
        }
        maze[row][col] = 1;
        crossMaze(maze, row+1, col);
        crossMaze(maze, row, col+1);
        maze[row][col] = 0;
    }
}
