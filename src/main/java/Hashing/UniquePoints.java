package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UniquePoints {
    public static void main(String[] args){
//        int[][] A = {{5,6},{2,8},{-1,-1},{2,-3},{2,8},{7,7},{2,-3}};
        int[][] A = {{618,403},
                     {618,415},
                     {618,403},
                     {618,403}};
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        int count=0;
        for(int i=0; i<A.length;i++){
            int x = A[i][0];
            int y = A[i][1];
            HashSet<Integer> hs = new HashSet();
            if(hm.containsKey(x)){
                hs = hm.get(x);
            }
            hs.add(y);
            hm.put(x,hs);
        }
        for(Integer key : hm.keySet()){
           HashSet<Integer> h = hm.get(key);
           count += h.size();
        }
        System.out.println(count);
    }
}
