package Sorting;

import java.util.Arrays;

public class NobleInteger {
    public static void main(String[] args){
        int A[] = {6, 7, 5};
        Arrays.sort(A);
        int cesi =0; int noble=0;
        for(int i=A.length-1; i>=0; i--){
            if(i==A.length-1) cesi = 0;
            else if(A[i] != A[i+1]){
                cesi = A.length-1-i;
            }
            if(cesi == A[i]){
                noble = 1;
            }
        }
        System.out.println(noble);
    }
}
