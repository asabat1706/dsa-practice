package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NQueen {
    static Set<Integer> cols_occupied = new HashSet<>();
    static Set<Integer> left_diagonals = new HashSet<>();
    static Set<Integer> right_diagonals = new HashSet<>();
    static ArrayList<ArrayList<String>> ans_board = new ArrayList<>();
    public static void main(String[] args){
        int input = 4;
        int[][] chess_board = new int[input][input];
        placeQueens(chess_board, 0);
        System.out.println(ans_board);
    }

    private static void placeQueens(int[][] chess_board, int row) {
        if(row == chess_board.length){
            ArrayList<String> queenpos = new ArrayList<>();
            for(int i=0; i<chess_board.length; i++){
                StringBuilder queen_pos= new StringBuilder();
                for(int j=0; j<chess_board.length; j++){
                    if(chess_board[i][j] == 0){
                        queen_pos.append('.');
                    }
                    else queen_pos.append('Q');
                }
               queenpos.add(queen_pos.toString());
            }
            ans_board.add(queenpos);
            return;
        }
        for(int col=0; col<chess_board.length; col++){
            if(isSafe(row,col)){
                chess_board[row][col] = 1;
                cols_occupied.add(col);
                left_diagonals.add(row-col);
                right_diagonals.add(row+col);
                placeQueens(chess_board,row+1);
                chess_board[row][col] = 0;
                cols_occupied.remove(col);
                left_diagonals.remove(row - col);
                right_diagonals.remove(row + col);

            }
        }
    }

    private static boolean isSafe(int row, int col) {
        if(cols_occupied.contains(col)) return false;
        if(left_diagonals.contains(row-col)) return false;
        if(right_diagonals.contains(row+col)) return false;

        return true;
    }
}
