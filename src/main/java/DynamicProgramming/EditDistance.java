package DynamicProgramming;

public class EditDistance {
    public static void main(String[] args){
        String A = "anshuman";
        String B = "antihuman";
        int[][] edit_dist_mat = new int[2][B.length()+1];
        int row=0;
        for(int i=A.length()-1; i>=0; i--){
            for(int j=B.length()-1; j>=0; j--){
                int min_step=0;
                if(A.charAt(i) != B.charAt(j)){
                    int del = 1 + edit_dist_mat[row+1][j];
                    int ins = 1 + edit_dist_mat[row][j+1];
                    int rep = 1 + edit_dist_mat[row+1][j+1];
                    min_step = Math.min(rep,Math.min(del,ins));
                }
                else{
                    min_step = edit_dist_mat[row+1][j+1];
                }
                edit_dist_mat[row][j] = min_step;
            }
            for(int k=0; k<B.length(); k++){
                edit_dist_mat[1][k] = edit_dist_mat[0][k];
                edit_dist_mat[0][k] = 0;
            }
        }
        System.out.println(edit_dist_mat[1][0]);
    }
}
