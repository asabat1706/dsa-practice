package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Sudoku {
    static HashMap<Integer,HashSet<Integer>> rows_visited = new HashMap<>();
    static HashMap<Integer,HashSet<Integer>> cols_visited = new HashMap<>();
    static HashMap<Integer,HashSet<Integer>> blocks_visited = new HashMap<>();

    public static void main(String[] args){
        char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};

//        char[][] sudoku = {{'.','.','.','.'},
//                           {'.','.','.','.'},
//                           {'.','.','.','.'},
//                           {'.','.','.','.'}};

        for(int row=0; row< sudoku.length; row++) {
            for (int col = 0; col < sudoku.length; col++) {
                if (sudoku[row][col] != '.') {
                    if (!rows_visited.containsKey(row)) {
                        HashSet<Integer> nums = new HashSet<>();
                        nums.add(sudoku[row][col] - '0');
                        rows_visited.put(row, nums);
                    } else {
                        HashSet<Integer> nums = rows_visited.get(row);
                        nums.add(sudoku[row][col] - '0');
                        rows_visited.put(row, nums);
                    }
                    if (!cols_visited.containsKey(col)) {
                        HashSet<Integer> nums = new HashSet<>();
                        nums.add(sudoku[row][col] - '0');
                        cols_visited.put(col, nums);
                    } else {
                        HashSet<Integer> nums = cols_visited.get(col);
                        nums.add(sudoku[row][col] - '0');
                        cols_visited.put(col, nums);
                    }
                    int blocks = (int) Math.sqrt(sudoku.length);
                    int block_col = col / blocks;
                    int block = row + block_col;
                    if (!blocks_visited.containsKey(block)) {
                        HashSet<Integer> nums = new HashSet<>();
                        nums.add(sudoku[row][col] - '0');
                        blocks_visited.put(block, nums);
                    } else {
                        HashSet<Integer> nums = blocks_visited.get(block);
                        nums.add(sudoku[row][col] - '0');
                        blocks_visited.put(block, nums);
                    }
                }
            }
        }
        solveSudoku(sudoku,0,0);
        for(int i=0; i< sudoku.length; i++){
            for(int j=0; j< sudoku.length; j++){
                System.out.print(sudoku[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static void solveSudoku(char[][] sudoku, int row, int col) {
        if((row== sudoku.length) || (col == sudoku[0].length)){
            return;
        }
        if(sudoku[row][col] != '.'){
            if(col == sudoku[0].length-1){
                col = -1;
                row = row+1;
            }
            solveSudoku(sudoku,row, (col+1));
        }
        for(int num = 1; num <= sudoku.length; num++){
                if(isSafe(sudoku, row, col, num)){
                    if(!rows_visited.containsKey(row)){
                        HashSet<Integer> nums = new HashSet<>();
                        nums.add(num);
                        rows_visited.put(row,nums);
                    }
                    else{
                        HashSet<Integer> nums = rows_visited.get(row);
                        nums.add(num);
                        rows_visited.put(row,nums);
                    }
                    if(!cols_visited.containsKey(col)){
                        HashSet<Integer> nums = new HashSet<>();
                        nums.add(num);
                        cols_visited.put(col,nums);
                    }
                    else{
                        HashSet<Integer> nums = cols_visited.get(col);
                        nums.add(num);
                        cols_visited.put(col,nums);
                    }
                    int blocks = (int) Math.sqrt(sudoku.length);
                    int block_row = row/blocks;
                    int block_col = col/blocks;
                    int block = (block_row*blocks) + block_col;
                    if(!blocks_visited.containsKey(block)){
                        HashSet<Integer> nums = new HashSet<>();
                        nums.add(num);
                        blocks_visited.put(block,nums);
                    }
                    else{
                        HashSet<Integer> nums = blocks_visited.get(block);
                        nums.add(num);
                        blocks_visited.put(block,nums);
                    }
                    sudoku[row][col] = Character.forDigit(num,10);
                    int temp_row = row;
                    int temp_col = col;
                    if(col == sudoku[0].length-1){
                        row = row+1;
                        col = -1;
                    }
                    solveSudoku(sudoku,row, col+1);
                    sudoku[temp_row][temp_col] = '.';
                    HashSet<Integer> rows = rows_visited.get(temp_row);
                    rows.remove(num);
                    HashSet<Integer> cols = cols_visited.get(temp_col);
                    cols.remove(num);
                    HashSet<Integer> block_v = blocks_visited.get(block);
                    block_v.remove(num);
                }
            }
    }

    private static boolean isSafe(char[][] sudoku, int row, int col, int num) {
        if(rows_visited.containsKey(row)){
            HashSet<Integer> nums = rows_visited.get(row);
            if(nums.contains(num))
                return false;
        }
        if(cols_visited.containsKey(col)){
            HashSet<Integer> nums = cols_visited.get(col);
            if(nums.contains(num))
                return false;
        }
        int blocks = (int) Math.sqrt(sudoku.length);
        int block_row = row/blocks;
        int block_col = col/blocks;
        int block = (block_row*blocks) + block_col;
        if(blocks_visited.containsKey(block)){
            HashSet<Integer> nums = blocks_visited.get(block);
            if(nums.contains(num))
                return false;
        }
       return true;
    }
}
