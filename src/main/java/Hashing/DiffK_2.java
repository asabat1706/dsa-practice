package Hashing;

import java.util.HashMap;
import java.util.Map;

public class DiffK_2 {
    public static void main(String[] args){
        int[] A={1,2,3};
        int B=0; int ans=0;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<A.length; i++){
            if(!hm.containsKey(A[i])){
                hm.put(A[i],1);
                continue;
            }
            hm.put(A[i],hm.get(A[i])+1);
        }
        for(int i=0; i<A.length; i++){
            int pair = B+A[i];
            if(pair==A[i]){
                if(hm.get(A[i])>1)
                    ans=1;
            }
            else if(hm.containsKey(pair)){
                ans=1;
            }
        }
        System.out.println(ans);
    }
}
