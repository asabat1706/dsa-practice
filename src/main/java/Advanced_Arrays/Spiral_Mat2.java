package Advanced_Arrays;

public class Spiral_Mat2 {
    public static void main(String[] args){
        int A = 5;
        int[][] ans_mat = new int[A][A];
        int num = 1;
        int row_min = 0, row_max = A-1, col_min = 0, col_max = A-1;
        while(num <= A*A){
                for(int col = col_min; col<=col_max; col++){
                    ans_mat[row_min][col] = num;
                    num++;
                }
                row_min++;
                for(int row = row_min; row<=row_max; row++){
                    ans_mat[row][col_max] = num;
                    num++;
                }
                col_max--;
                for(int col = col_max; col>=col_min; col--){
                   ans_mat[row_max][col] = num;
                   num++;
                }
                row_max--;
                for(int row = row_max; row>=row_min; row--){
                    ans_mat[row][col_min] = num;
                    num++;
                }
                col_min++;
        }

        for(int i=0; i<A; i++){
            for(int j=0; j<A; j++){
                System.out.print(ans_mat[i][j] + "   ");
            }
            System.out.println("   ");
        }
    }
}
