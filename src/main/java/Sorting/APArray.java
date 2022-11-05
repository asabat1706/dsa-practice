package Sorting;

import java.util.Arrays;

public class APArray {
    public static void main(String[] args){
        int A[] = {-113, -70, -14, -8, -29, 5, -94, -44, 23, 9, 13, -132, -14};
        Arrays.sort(A);
        int diff = A[1] -A[0]; boolean isAP=false;
        for(int i=1; i<A.length-1; i++){
            if(A[i+1]-A[i]==diff)
                isAP = true;
            else break;
        }
        System.out.println(isAP);
    }
}
