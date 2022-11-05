package DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] A = {8,4,12,2,10,6,14};
        int[] DP = new int[A.length];
        for(int i=0; i<DP.length; i++){
            DP[i] = 1;
        }
        for(int j=1; j<A.length; j++){
            for(int i=0; i<j; i++){
                if(A[i] < A[j]){
                    DP[j] = Math.max(DP[j],DP[i]+1);
                }
            }
        }

        for(int i=0; i<DP.length; i++){
            System.out.print(DP[i] + "  ");
        }
    }
}
