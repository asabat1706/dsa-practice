package Searching;

import java.util.Arrays;

public class KthPrice {
    public static void main(String[] args){
        int[] A = {2, 1, 4, 3, 2};
        int B = 3;
        Arrays.sort(A);
        System.out.println(A[B-1]);
    }
}
