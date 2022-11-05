package Sorting;

import java.util.*;

public class LargestNumber {
    public static void main(String[] args){
        int A[]={8,89};
        String[] B = new String[A.length];
        for(int i=0; i<A.length; i++)
            B[i] = String.valueOf(A[i]);
        Arrays.sort(B, new Comparator<String>(){
            @Override
            public int compare(String o2, String o1) {
                String i1 = o1 + o2;
                String i2 = o2 + o1;
                if (Long.parseLong(i1) > Long.parseLong(i2)) return 1;
                else if (Long.parseLong(i1) < Long.parseLong(i2)) return -1;
                else return 0;
            }
        });
        String s= String.valueOf(B[0]);
        for(int i=1; i<B.length; i++)
            if(!B[i].equals("0"))
                s = s+B[i];

        System.out.println(s);
    }
}
