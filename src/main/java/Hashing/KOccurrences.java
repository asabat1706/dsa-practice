package Hashing;

import java.util.*;

public class KOccurrences {
    public static void main(String[] args){

    }
    public int getSum(int A, int B, ArrayList<Integer> C) {
        // System.out.println(C);
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<C.size(); i++){
            if(!hm.containsKey(C.get(i))){
                hm.put(C.get(i),1);
            }
            else{
                int c = hm.get(C.get(i));
                hm.put(C.get(i),c+1);
            }
        }
        Set<Integer> keys = hm.keySet();
        // System.out.println(keys);
        Iterator itr = keys.iterator();
        int sum=0; int count=0;
        int mod = (int)Math.pow(10,9);
        while(itr.hasNext()){
            Integer num = (Integer)itr.next();
            // System.out.println("num, B "+ num+" "+B);
            // System.out.println("freq " + hm.get(num));
            if(hm.get(num) == B){
                sum = ((sum%(mod+7))+(num%(mod+7)))%(mod+7);
            }
            else count++ ;
        }
        if(count== keys.size()) return -1;
        return sum;
    }
}
