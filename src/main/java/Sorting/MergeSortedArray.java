package Sorting;

public class MergeSortedArray {
    public static void main(String[] args){
        int[] A = {4, 7, 9};
        int[] B = {2, 11, 19};
        int[] merged = new int[A.length+B.length];
        int i=0,j=0,index=0;
        while(i<A.length && j<B.length){
            if(A[i]<B[j]){
                merged[index] = A[i];
                i++;
            }
            else if(A[i]>B[j]){
                merged[index] = B[j];
                j++;
            }
            else{
                merged[index] = B[j];
                index++;
                merged[index] = A[i];
                j++; i++;
            }
           index++;
        }
        if(i < A.length){
            while(i<A.length){
               merged[index] = A[i];
               i++;index++;
            }
        }
        else if(j < B.length){
            while(j<B.length){
                merged[index] = B[j];
                j++;index++;
            }
        }
        for(int k=0; k<merged.length; k++){
            System.out.print(merged[k]+ " ");
        }
    }
}
