package Recursion;

public class SearchWord {
    public static void main(String[] args){
//        char[][] board = {{'A'}};
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "OU";
//        char[][] board = {{'D','E'}};
        String word = "BCCED";
        boolean ans = false;
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                 ans = exists(board,i,j,0,word);
                 if(ans) {
                     break;
                 }
            }
            if(ans) {
                break;
            }
        }
        System.out.println(ans);
    }

    public static boolean exists(char[][]board, int row, int col, int index, String word){

        if(row<0 || (row>board.length-1 )|| col<0 || (col>board[0].length-1)){
            return false;
        }
        if(board[row][col] == '$'){
            return false;
        }
        if(index == word.length()-1){
            if(word.charAt(index) == board[row][col]){
                return true;
            }
            else{
                return false;
            }
        }
        boolean left =false;
        boolean right=false;
        boolean top = false;
        boolean bottom = false;
        if(word.charAt(index) == board[row][col]) {
            char temp = board[row][col];
            board[row][col] = '$';
            left = exists(board, row, col - 1, index + 1, word);
            right = exists(board, row, col + 1, index + 1, word);
            top = exists(board, row - 1, col, index + 1, word);
            bottom = exists(board, row + 1, col, index + 1, word);
            board[row][col] = temp;

        }
        return left || right || top || bottom;


    }
}
