package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongesSubarraySumZero {
    public static void main(String[] args){
        int A[]={0, -10, -12, -8, 21, -11, -28, -11, 0, -8,17, -1, -4, -7, -5, 22, -26, -24, -7, 13, 18, -21, 10};
//        int A[]={1, 2, -3, 3};
//        int A[]= {1,2,-2,4,-4};
//        int A[]={ -8, 8,-14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25};
//        int A[]={11, -11, -4, 2, -11, 1, -13, 10, -14, 7, 11, -26, 0, 16, 18, 6, -2, -1};
//       int A[] = {-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25};
//       int A[] = {-14, -10, -1, 2, 12, -19, 27, -20, 0, 11};
       int PS[] = new int[A.length];
        int maxZeroLen=Integer.MIN_VALUE;
        int s=-1; int e=-1; boolean isZero=false; int prev_zero=-1;
        PS[0] = A[0];
        for(int i=1; i<A.length; i++){
            PS[i] = A[i]+PS[i-1];
        }
        Map<Integer,Integer> hs = new HashMap<>();
        for(int i=0; i<PS.length; i++){
            if(!hs.containsKey(PS[i]) && PS[i] !=0){
                hs.put(PS[i],i);
                continue;
            }
            int s1,e1;
            if(PS[i]==0) {
                s1 = 0;
                e1 = i;
                if ((e1 - s1 + 1) > maxZeroLen) {
                    s = s1;
                    e = e1;
                    maxZeroLen = (e - s + 1);
                    isZero = true;
                }
                } else {
                    s1 = hs.get(PS[i]);
                    e1 = i;
                    if ((e1 - s1) > maxZeroLen) {
                        s = s1;
                        e = e1;
                        maxZeroLen = (e - s);
                        isZero = false;
                    }
                }
        }
        PS=null;
        int B[] = {}; int k=0;
        if((e !=-1) && (s !=-1)){
           int i=0; B= new int[maxZeroLen];
           if(isZero)
               i=0;
           else
               i=s+1;
        while (i<=e){
            B[k] = A[i];
            System.out.print(B[k]+" ");
            k++; i++;
        }
        }
    }
}
