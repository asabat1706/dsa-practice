package TwoPointers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class PairsWithDifference {
    public static void main(String[] args){
//        int[] A ={8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
        int[] A = {1,2};
        int B=0;
        int count=0;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=0; i<A.length; i++){
            if(!tm.containsKey(A[i])){
                tm.put(A[i],1);
            }
            else{
                tm.put(A[i],2);
            }
        }
        for (Integer a : tm.keySet()) {
            int b = B + a;
            if (tm.containsKey(b))
                if(a==b){
                   if(tm.get(a)>1) count++;
                }
                else count++;
        }
        System.out.println(count);
    }
}
