package Hashing;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class CountRectangles {
    public static void main(String[] args){
        int[] A = {1, 1, 2, 2};
        int[] B = {1, 2, 1,2};
        int N = A.length; int count=0;
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<N; i++){
            String p = A[i] + "#" + B[i];
            if(!hs.contains(p)){
                hs.add(p);
            }
        }
        for(int i=0;i<N; i++){
            for(int j=i+1; j<N; j++){
                if((A[i] != A[j]) && (B[i] != B[j])){
                    String x1_cord = A[i] + "";
                    String x2_cord = A[j] + "";

                    String y1_cord = B[j] + "";
                    String y2_cord = B[i] + "";

                    String p1 = x1_cord + "#" + y1_cord;
                    String p2 = x2_cord + "#" + y2_cord;

                    if(hs.contains(p1) && hs.contains(p2))
                        count++;
                }
            }
        }
        System.out.println(count);
    }
}
