package Hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args){
//        int[] A={2,2,7,7,15};
        int[] A={4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 };
        int B=-3;
        int C[]=new int[2];
        int num1=0,index1=-1,index2 = -1;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<A.length; i++){
            if(!hm.containsKey(A[i])){
                hm.put(A[i],1);
            }
            else{
                hm.put(A[i],hm.get(A[i])+1);
            }
            int pair = B - A[i];
            if(pair==A[i]) {
                if(hm.get(A[i])>1) {
                    num1 = A[i];
                    index2=i;
                    break;
                }
            }
            else if(hm.containsKey(pair)){
                num1=pair;
                index2=i;
                break;
            }
        }
        if(index2 !=-1) {
            for (int i = 0; i < (index2 + 1); i++) {
                if (A[i] == num1) {
                    index1 = i + 1;
                    C[0] = index1;
                    System.out.println(C[0]);
                    break;
                }
            }
            C[1] = index2+1;
            System.out.println(C[1]);
        }
        else C=new int[]{};
    }
}
