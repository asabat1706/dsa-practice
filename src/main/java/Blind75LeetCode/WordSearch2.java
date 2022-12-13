package Blind75LeetCode;

import java.util.*;

public class WordSearch2 {
    static List<String> ans = new ArrayList<>();
    static StringBuilder wordformed = new StringBuilder();
    static boolean[][] visited;
    public static void main(String[] args){
        char[][] board =
                {{'i','h','k','r'},{'i','f','l','v'}};

        String[] words ={"hklf", "hf"};

        visited = new boolean[board.length][board[0].length];
        for(boolean[] row : visited){
            Arrays.fill(row,false);
        }
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length; j++){
                for(int k=0; k<words.length; k++){
                    if(words[k] != "$"){
                        boolean isPresent=checkforWord(board,words[k],i,j,0);
                        wordformed= new StringBuilder();
                        if(isPresent){
                            words[k]="$";
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean checkforWord(char[][] board, String word, int row, int col, int index) {
        if(index == word.length()){
            visited[row][col]=false;
                if(wordformed.toString().equals(word) && !ans.contains(word)){
                    ans.add(word);
                    return true;
                }
            return false;
        }
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;
        if(board[row][col] == word.charAt(index) && !visited[row][col]){
            wordformed.append(word.charAt(index));
            visited[row][col] = true;
            if(wordformed.toString().equals(word) && !ans.contains(word)){
                ans.add(word);
                visited[row][col]=false;
                return true;
            }
            if(col-1 >= 0 && !visited[row][col-1]){
                left = checkforWord(board,word,row, col-1, index+1);
            }
            if(!left){
                if((col+1) < board[0].length && !visited[row][col+1]){
                    right = checkforWord(board,word,row, col+1, index+1);
                }
                if(!right){
                    if((row-1) >= 0 && !visited[row-1][col]){
                        up = checkforWord(board,word,row-1, col, index+1);
                    }
                    if(!up){
                        if((row+1) < board.length && !visited[row+1][col]){
                            down = checkforWord(board,word,row+1, col, index+1);
                        }
                        visited[row][col]=false;
                        wordformed.deleteCharAt(wordformed.length()-1);
                        return down;
                    }
                    visited[row][col]=false;
                    return true;
                }
                visited[row][col]=false;
                return true;
            }
            visited[row][col]=false;
            return true;
        }
        visited[row][col]=false;
        return false;
    }
}
