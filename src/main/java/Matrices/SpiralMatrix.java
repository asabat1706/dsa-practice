package Matrices;

public class SpiralMatrix {
    public static void main(String[] args){
        int num = 2;
        int max_num = num*num;
        int A[][] = new int[num][num];
        int start_num = 1;
        char direction = 'R';
        int max_col = num-1, max_row = num-1, min_col = 0, min_row=0;
        while(start_num <= max_num){
            if(direction == 'R'){
                for(int i=min_col; i<= max_col; i++){
                    A[min_row][i] = start_num;
                    start_num++;
                }
                direction = 'D';
                min_row++;
            }
            else if(direction == 'D'){
                for(int i=min_row; i<= max_row; i++){
                    A[i][max_col] = start_num;
                    start_num++;
                }
                direction = 'L';
                max_col--;
            }
            else if(direction == 'L'){
                for(int i=max_col; i>= min_col; i--){
                    A[max_row][i] = start_num;
                    start_num++;
                }
                direction = 'U';
                max_row--;
            }
            else if(direction == 'U'){
                for(int i=max_row; i>= min_row; i--){
                    A[i][min_col] = start_num;
                    start_num++;
                }
                direction = 'R';
                min_col++;
            }
        }
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A.length; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
