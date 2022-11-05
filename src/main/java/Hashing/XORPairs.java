package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class XORPairs {
    public static void main(String[] args){
        int[] A={3, 6, 8, 10, 15, 50};
        int B=5; int count=0;
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<A.length; i++){
            if(!hm.containsKey(A[i]))
                hm.put(A[i],1);
            else
                hm.put(A[i], hm.get(A[i])+1);
        }
        for(int i=0; i<A.length; i++){
            if(!hs.contains(A[i])) {
                int pair = A[i] ^ B;
                if (hm.containsKey(pair)) {
                    count += (hm.get(A[i]) * hm.get(pair));
                    hs.add(pair);
                }
            }
        }
        System.out.println(count);

    }
}
