package DynamicProgramming;

public class LongestIncreasingSubseq {
    public static void main(String[] args){
        String A = "abbcdgf";
        String B = "bbadcgf";
        int n = A.length();
        int m = B.length();
        int[][] DP = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    DP[i][j] = 1 + DP[i-1][j-1];
                }
                else{
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                }
            }
        }
        System.out.println(DP[n][m]);
    }
}
