package Sorting;

public class KthSmallestElement {
    public static void main(String[] args){
        int[] A={2, 1, 4, 3, 2};
        int B=3;
        for(int i=0; i<B; i++){
            int j; int min = Integer.MAX_VALUE; int min_index=-1;
            for(j=i; j<A.length; j++){
                if(A[j] < min) {
                    min = A[j];
                    min_index = j;
                }
            }
            int temp =A[i];
            A[i] = min;
            A[min_index] = temp;
        }
        for(int i=0; i<A.length; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println(A[B-1]);
    }
}
