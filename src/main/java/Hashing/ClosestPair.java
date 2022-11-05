package Hashing;

import java.util.HashMap;
import java.util.Map;

public class ClosestPair {
    public static void main(String[] args){
//        int A[] = {7, 1, 3, 4, 1, 7};
        int A[] = {1,1};
        int min_length = Integer.MAX_VALUE;
        Map<Integer,Integer> hs = new HashMap<>();
        for(int i=0; i<A.length; i++){
            if(!hs.containsKey(A[i])){
                hs.put(A[i],i);
                continue;
            }
            int s = hs.get(A[i]);
            int e = i;
            if((e-s)<min_length)
                min_length = e-s;
        }
        System.out.println(min_length);
    }
}
