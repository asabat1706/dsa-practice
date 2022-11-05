package Advanced_Arrays;

public class SubmatrixSum {
    public static void main(String[] args){
        int A[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] B = {1, 2};
        int[] C = {1, 2};
        int[] D = {2, 3};
        int[] E = {2, 3};
        long[][] PS = new long[A.length][A[0].length];
        for(int row=0; row<A.length; row++){
            PS[row][0] = A[row][0];
            for(int col=1; col<A[0].length; col++){
                PS[row][col] = PS[row][col-1] + A[row][col];
            }
        }
        for(int col=0; col<A[0].length; col++){
            for(int row=1; row<A.length; row++){
                PS[row][col] += PS[row-1][col];
            }
        }

        int sum[] = null;
        if(B.length == C.length && C.length == D.length && D.length == E.length){
            sum = new int[B.length];
            for(int q=0; q<B.length; q++){
                int r2 = D[q]-1;  int c2 = E[q]-1;
                int r1 = B[q]-1;  int c1 = C[q]-1;
                long sub_sum = 0;
                if(r1 == 0 || c1 == 0) sub_sum = PS[r2][c2];
                else sub_sum = PS[r2][c2] - PS[r1-1][c2] - PS[r2][c1-1] + PS[r1-1][c1-1];
                int factor = (int)Math.pow(10,9)+7;
                sum[q] = (int)(sub_sum %factor);
            }
        }
        for(int i=0; i<sum.length; i++){
            System.out.print(sum[i] + "  ");
        }
    }
}
