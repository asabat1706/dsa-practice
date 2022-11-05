package Sorting;

public class SortByColor {
    public static void main(String[] args){
        int A[] = {0,1,2,0,1,2};
        int C[] = new int[3];
        int B[] = new int[A.length];
        for(int i=0; i<A.length; i++){
            if(A[i]==0) C[0] = C[0]+1;
            else if(A[i]==1) C[1] = C[1]+1;
            else C[2] = C[2]+1;
        }
        for(int i=0; i<B.length; i++){
            if(C[0] != 0){
                B[i] = 0;
                C[0] = C[0] -1;
            }
            else if(C[1] != 0){
                B[i] = 1;
                C[1] = C[1] - 1;
            }
            else{
                B[i] = 2;
                C[2] = C[2]-1;
            }
        }
        for(int i=0; i<B.length; i++){
            System.out.print(B[i]+" ");
        }
    }
}
