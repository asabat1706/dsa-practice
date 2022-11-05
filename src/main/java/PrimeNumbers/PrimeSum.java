package PrimeNumbers;

import java.util.HashMap;
import java.util.HashSet;

public class PrimeSum {
    public static void main(String[] args){
//        int A =1048574;
        int A=16777214;
        HashSet<Integer> hs = new HashSet<>();
        boolean[] find_primes = new boolean[A+1];
        for(int i=0; i<=A; i++){
            find_primes[i]=true;
        }
        for(int i=2; i<find_primes.length; i++){
            if(find_primes[i]==true){
                hs.add(i);
                for(int j=2*i; j<find_primes.length; j+=i){
                    find_primes[j]=false;
                }
            }
        }
        int[] ps = {Integer.MAX_VALUE,Integer.MAX_VALUE};
        for(Integer i:hs){
            int a1 = A-i;
            if(hs.contains(i) && hs.contains(a1)){
                if(i < ps[0]) {
                    ps[0] = Math.min(i, a1);
                    ps[1] = Math.max(i, a1);
                    System.out.print("1 " + ps[0] + " 2 " + ps[1]);
                }
            }
        }
    }
}
