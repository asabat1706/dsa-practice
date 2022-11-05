package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_BF {
    public static void main(String[] args){
        int A=16;
        List<Integer> binary = new ArrayList<>();
        for(int i=0; i<Math.pow(2,A); i++){
            String s = converDTB(i,A);
            s = convertBTG(s.toCharArray());
            int n = convertBTD(s);
            binary.add(n);
        }
        System.out.println(binary);
    }

    private static int convertBTD(String s) {
        int sum=0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='1')
            {
                sum = sum + (int)Math.pow(2,(s.length()-(i+1)));
            }
        }
        return sum;
    }

    private static String converDTB(int n, int a) {
        String s="";
        while(n>0){
            s = n%2+s;
            n = n/2;
        }
        while(s.length()<a)
            s = "0"+s;
        return s;
    }

    private static String convertBTG(char[] a) {
        String str = a[0]+"";
       for(int i=1;i<a.length; i++){
           str = str+((Integer.parseInt(String.valueOf(a[i])))^(Integer.parseInt(String.valueOf(a[i-1]))));
       }
       return str;
    }

}
