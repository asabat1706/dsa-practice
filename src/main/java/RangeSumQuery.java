public class RangeSumQuery {
    public static void main(String[] args){
        int A[] = {7, 3, 1, 5, 5, 5, 1, 2, 4, 5};
        int B[][] = {{7,10},{3,10},{3,5},{1,10}};
        long C[] = new long[B.length];
        long PS[] = new long[A.length];
        PS[0] = A[0];
//        find prefix sum of A
        for(int i=1; i<A.length; i++){
            PS[i] = A[i] + PS[i-1];
        }
       for(int i=0; i< B.length; i++){
              int s = B[i][0] - 1;
              int e = B[i][1] - 1;
              if(s==0)
                C[i] = PS[e] ;
              else
                C[i] = PS[e] - PS[s-1];
       }

    }
}
