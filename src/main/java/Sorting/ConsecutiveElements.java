package Sorting;

import java.util.Arrays;

public class ConsecutiveElements {
    public static void main(String[] args){
        int[] A = {3};
        int ans = 1;
        Arrays.sort(A);
        for(int i=1; i<A.length; i++){
            if(A[i] != (A[i-1]+1)){
                ans = 0;
                break;
            }
        }
        System.out.println(ans);
    }
}
