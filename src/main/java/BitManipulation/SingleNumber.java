package BitManipulation;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args){
        int A[] = {1,2,2,3,1,4};
        int B[] = new int[2]; int t=0;
        int max=A[0],min=A[0];
        for(int i=0; i<A.length; i++){
            if(max<A[i]) max = A[i];
        }
        for(int i=0; i<A.length; i++){
            if(A[i] < min) min = A[i];
        }
        int c[] = new int[max-min+1];
        for(int i=0; i<A.length; i++){
            c[A[i]-min] = c[A[i]-min]+1;
        }
        for(int i=0; i<A.length; i++){
            if(c[A[i]-min]==1) {
                B[t] = A[i];
                t++;
            }
        }
        Arrays.sort(B);
        System.out.println(B[0]+ " --- "+B[1]);
    }
}
