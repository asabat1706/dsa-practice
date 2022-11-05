package PermutationAndCombination;

import java.util.*;

public class RankOfString {
    public static void main(String[] args) {
        String s = "acb";
        long rank = 1;
        int mod = 1000003;
       for(int i=0; i<s.length(); i++){
           int count_lower_chars=0;
           int[] freq_chars = new int[52];
         for(int j=i+1; j<s.length(); j++){
             if(s.charAt(i) > s.charAt(j))
                 count_lower_chars++;
         }
         long fact_num = ((count_lower_chars%mod) * (factorial(s.length()-1-i,mod)%mod))%mod;
          for(int j=i; j<s.length(); j++)
           {
               if(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
                   int index = s.charAt(j) - 'A';
                   freq_chars[index] = freq_chars[index]+1;
               }
               else{
                   int index = s.charAt(j) - 'a' + 26;
                   freq_chars[index] = freq_chars[index]+1;
               }
           }
          long fact=1;
           for(int j=0; j<freq_chars.length; j++){
               if(freq_chars[j] > 1) {
                   long fact_den = factorial(freq_chars[j], mod);
                   long fact_inverse = pow(fact_den,mod-2,mod);
                   fact = ((fact%mod) * (fact_inverse%mod))%mod;
               }
           }
           fact = ((fact%mod) * (fact_num%mod))%mod;
           rank = ((rank%mod) + (fact%mod))%mod;
       }
        System.out.println(rank);
    }

    private static long pow(long fact_den, int p, int mod) {
        if(p==0) return 1;
        long x = pow(fact_den,p/2,mod);
        long y = ((x%mod) * (x%mod))%mod;
        if(p%2==0) return y;
        else return ((fact_den%mod)*(y%mod))%mod;
    }

    private static long factorial(Integer n, Integer mod) {
        if(n==0) return 1;
        else return ((n%mod) * (factorial(n-1,mod)%mod))%mod;

    }
}
