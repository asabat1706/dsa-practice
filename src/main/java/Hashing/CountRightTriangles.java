package Hashing;

import java.util.HashMap;

public class CountRightTriangles {
    public static void main(String[] args){
        int[] A={1, 1, 2, 3, 3};
        int[] B={1, 2, 1, 2, 1};
        int N = A.length; int mod = 1000000007;
        HashMap<Integer,Integer> x_axis = new HashMap<>();
        HashMap<Integer,Integer> y_axis = new HashMap<>();
        for(int i=0; i<N; i++){
            if(!x_axis.containsKey(A[i]))
                x_axis.put(A[i],1);
            else x_axis.put(A[i],x_axis.get(A[i])+1);

            if(!y_axis.containsKey(B[i]))
                y_axis.put(B[i],1);
            else y_axis.put(B[i],y_axis.get(B[i])+1);
        }
         int count=0;
        for(int i=0; i<N; i++){
            int total_freq = (x_axis.get(A[i])-1) * (y_axis.get(B[i])-1);
             count = count + total_freq;
        }
        System.out.println(count);
    }
}
