package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CostOfRemoval {
    public static void main(String[] args){
        int[] A = {5,2,1};
        Arrays.sort(A);
        int min_cost=0;
        for(int i=0; i<A.length; i++){
            int frequency = A.length-i;
            min_cost = min_cost + (frequency*A[i]);
        }
        System.out.println(min_cost);
    }
}
