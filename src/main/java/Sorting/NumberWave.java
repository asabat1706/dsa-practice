package Sorting;

import java.util.Arrays;

public class NumberWave {
    public static void main(String[] args){
        int A[] = {5,3,4,1,2,2};
        Arrays.sort(A);
        for(int i=0; i<A.length-1; i+=2){
            int j = i+1;
            int temp = A[i];
            A[i]=A[j];
            A[j]=temp;
        }
        for(int i=0; i<A.length; i++){
            System.out.print(A[i]+"  ");
        }
    }
}
