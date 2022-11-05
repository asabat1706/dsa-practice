package DynamicProgramming;

public class MaxSum {
    public static void main(String[] args){
        int[][] input = {{2, 6, 6, 1, 16, 6, 15},{9, 16, 5, 4, 20, 3, 3}};
        int ans = Integer.MIN_VALUE;
        int[] DP = new int[input[0].length];
        DP[0] = Math.max(input[0][0], input[1][0]);
        if(input[0].length == 1){
            ans = DP[0];
        }
        DP[1] = Math.max(DP[0],Math.max(input[0][1], input[1][1]));
        if(input[0].length == 2){
            ans = DP[1];
        }
        for(int i=2; i<input[0].length; i++){
            int prev_max = DP[i-2];
            for(int j=i-2; j>=0; j--){
                prev_max = Math.max(DP[j],prev_max);
            }
            int max_sum = prev_max + Math.max(input[0][i], input[1][i]);
            ans = Math.max(max_sum,ans);
            DP[i] = max_sum;
        }
        System.out.println(ans);
    }
}
