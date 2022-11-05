package AdvancedBitManipulations;

import java.util.Arrays;

public class MinXorPair {
    public static void main(String[] args){
        int[] A ={0, 4, 7, 9};
        int min_xor =Integer.MAX_VALUE;
        Arrays.sort(A);
        for(int i=0; i<A.length-1; i++){
            int xor = A[i] ^ A[i+1];
            min_xor = Math.min(min_xor,xor);
        }
        System.out.println(min_xor);
    }
}
