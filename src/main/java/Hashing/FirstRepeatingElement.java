package Hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {
    public static void main(String[] args){
//        int A[] = {10, 5, 3, 4, 3, 5, 6};
        int A[] = {8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3 };
        int ele=-1; int min_index=A.length+1;
        Map<Long,Integer> hs = new HashMap<>();
        for(int i=0; i<A.length; i++){
            if(!hs.containsKey((long)A[i])){
                hs.put((long) A[i],i);
                continue;
            }
            if(hs.get((long)A[i]) < min_index) {
                ele = A[i];
                min_index = hs.get((long)A[i]);
            }
        }
        System.out.println(ele);
    }
}
