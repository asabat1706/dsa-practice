package Strings;

import java.util.ArrayList;
import java.util.List;

public class AmazingSubarray {
    public static void main(String[] args){
        String A = "ABEC"; int count=0;
        List<Integer> startPoints = new ArrayList<>();
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)=='a'||A.charAt(i)=='e'||A.charAt(i)=='i'||A.charAt(i)=='o'||A.charAt(i)=='u'
            ||A.charAt(i)=='A'||A.charAt(i)=='E'||A.charAt(i)=='I'||A.charAt(i)=='O'||A.charAt(i)=='U')
               startPoints.add(i);
        }
        for(int i:startPoints){
            int s=i,e=A.length();
            for(int j=i; j<A.length();j++){
                count++;
            }
        }
        System.out.println(count);
    }
}
