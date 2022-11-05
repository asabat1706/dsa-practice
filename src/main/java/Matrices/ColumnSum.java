package Matrices;

public class ColumnSum {
    public static void main(String[] args){
        int A[][] = {{1,2,3,4},{5,6,7,8},{10,11,12,13}};
        int B[] = new int[A.length];
        int t=0;
        for(int j=0; j< A[0].length; j++){
            int sum=0;
            for(int i=0; i<A.length; i++){
                sum = sum + A[i][j];
            }
            B[t++] = sum;
        }
    }
}
