package Matrices;

public class MatrixTranspose {
    public static void main(String[] args){
        int A[][] = {{1,2},{1,2},{1,2}};
        int rows = A.length, cols = A[0].length;
        int B[][] = new int[cols][rows];

            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                  B[j][i] = A[i][j];
                }
        }
            for(int i=0; i<B.length; i++){
                for(int j=0; j<B[0].length; j++){
                    System.out.print(B[i][j]+ " ");
                }
                System.out.println(" ");
            }
    }
}
