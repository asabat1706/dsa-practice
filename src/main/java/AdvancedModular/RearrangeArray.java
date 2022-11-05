package AdvancedModular;

public class RearrangeArray {
    public static void main(String[] args){
        int[] A = {2,1,3,0};
        for(int i=0; i<A.length; i++){
            A[i] += (A.length*(A[A[i]]%A.length));
        }
        for(int i=0; i<A.length; i++){
            A[i] /= A.length;
            System.out.println(A[i] + "  ");
        }

    }
}
