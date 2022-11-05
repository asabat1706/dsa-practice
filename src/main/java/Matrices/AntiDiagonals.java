package Matrices;

public class AntiDiagonals {
    public static void main(String[] args){
        int A[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int C[][] = new int[2*A.length-1][A.length];
        int row1=0;
        for(int col=0; col<A.length; col++){
            int i=0, j=col, col1=0;
            while(i<A.length && j>=0){
                C[row1][col1] = A[i][j];
                i++; j--; col1++;
            }
            row1++;
        }
        for(int row=1; row < A.length; row++){
            int i= row, j= A.length-1, col1=0;
            while(i<A.length && j>=0){
                C[row1][col1] = A[i][j];
                i++; j--; col1++;
            }
            row1++;
        }

    }
}
