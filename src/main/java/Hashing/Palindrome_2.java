package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Palindrome_2 {
    public static void main(String[] args){
        System.out.println(colorful(1234));
    }
    public static int colorful(int A) {
        List<Integer> B = new ArrayList<>();
        int K =A;
        while(K>0){
            int n = K%10;
            B.add(n);
            K = K/10;
        }
        Collections.reverse(B);
        // System.out.println(B);
        HashSet<Long> hs = new HashSet<>();
        for(int i=0; i<B.size(); i++){
            long product = B.get(i);
            for(int j=i; j<B.size(); j++){
                if(i!=j)
                    product = product* B.get(j);
                // System.out.println(product);
                if(!hs.contains(product))
                    hs.add(product);
                else return 0;
            }
        }
        // if(A%100 == 0) return 0;
        return 1;
    }
}
