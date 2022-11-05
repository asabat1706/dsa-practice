package Hashing;

import java.util.*;

public class CommonElements {
    public static void main(String[] args){
        int A[]={1, 2, 2, 1,5,2};
        int B[]={2, 3, 1, 2};
        List<Integer> l = new ArrayList<>();
        Map<Integer,Integer> hs = new HashMap<>();
        if(A.length> B.length){
            for(int i=0; i<A.length; i++) {
                if (!hs.containsKey(A[i])){
                    hs.put(A[i],1);
                    continue;
                }
                    hs.put(A[i],hs.get(A[i])+1);
            }
            for(int i=0; i<B.length; i++){
                if(hs.containsKey(B[i])){
                   int c = hs.get(B[i]);
                   if(c>0) l.add(B[i]);
                   hs.put(B[i],c-1);
                }

            }
        }
        else{
            for(int i=0; i<B.length; i++) {
                if (!hs.containsKey(B[i])){
                    hs.put(B[i],1);
                    continue;
                }
                hs.put(B[i],hs.get(B[i])+1);
            }
            for(int i=0; i<A.length; i++){
                if(hs.containsKey(A[i])){
                    int c = hs.get(A[i]);
                    if(c>0) l.add(A[i]);
                    hs.put(A[i],c-1);
                }

            }
        }
        int C[] = new int[l.size()];
        for(int i=0; i<l.size(); i++){
            C[i] = l.get(i);
        }
        System.out.println(l);
    }
}
