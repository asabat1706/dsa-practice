package BitManipulation;

import java.util.*;

public class SingleNumber2 {
    public static void main(String[] args){
        int A[] = {1780, 170, 1157, 1922, 1032, 1922, 866, 681, 320, 2115, 1989, 1684, 1358, 2239, 681, 1501, 1989, 2239, 1780, 2416, 2115, 2416, 1501, 320, 483, 170, 1157, 1032, 1684, 483};
        int B[] = new int[2]; int t=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< A.length; i++){
            if(map.containsKey(A[i]))
                map.put(A[i],2);
            else map.put(A[i],1);
        }
        for(Map.Entry<Integer, Integer> count: map.entrySet()){
            if(count.getValue()==1) {
                B[t]=count.getKey();
                t++;
            }
        }

//        int xor = 0;
//        for(int i=0; i<A.length; i++){
//            xor = xor^A[i];
//        }
//        for(int i=0; i< A.length; i++){
//            int xor_temp = A[i]^xor;
//            if(s.contains(xor_temp)){
//              if(A[i]<xor_temp) {
//                        B[0] = A[i];
//                        B[1] = xor_temp;
//                    }
//                    else {
//                        B[0] = xor_temp;
//                        B[1] = A[i];
//                    }
//                }
//        }
        System.out.println(B[0]+ " --- "+B[1]);
    }
}
