package Hashing;

import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {
    public static void main(String[] args){
//        int[] A= {1,2,1,3,4,3};
//        int B=1;
//        int[] A={97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97};
//        int B=8;
        int[] A= {24, 24, 24, 24, 26, 70};
        int B=6;
        int[] C = new int[A.length-B+1];
        int index=1;
        if(B!=1 && B<=A.length) {
            Map<Integer,Integer> hm = new HashMap<>();
            for (int i = 0; i < B; i++) {
                if(!hm.containsKey(A[i])){
                    hm.put(A[i],1);
                    continue;
                }
                hm.put(A[i],hm.get(A[i])+1);
            }
            C[0]=hm.size();
            for(int i=1; i<=A.length-B; i++){
                int j = B+i-1;
                int freq = hm.get(A[i-1]);
                if(freq-1 ==0)
                    hm.remove(A[i-1]);
                else
                    hm.put(A[i-1],freq-1);
                if(hm.containsKey(A[j])){
                    hm.put(A[j],hm.get(A[j])+1);
                }
                else
                    hm.put(A[j],1);
                C[index] =hm.size();
                index++;
            }
            for(int i=0; i<C.length; i++)
                System.out.print(C[i]+" ");
        }
        else if(B==1){
            for(int i=0; i<=A.length-B; i++) {
                C[i] = A[i];
                System.out.print(C[i]+" ");
            }
        }
        else if(B>A.length){
            C= new int[]{};
        }
    }
}
