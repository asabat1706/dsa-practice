package Advanced_Arrays;

public class BeggarProb {
    public static void main(String[] args){
        int A = 5;
        int[][] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] coins = new int[A];
        for(int i=0; i<B.length; i++){
            int start = B[i][0];
            int end = B[i][1];
            int amt = B[i][2];
            coins[start-1] += amt;
            if(end<coins.length)coins[end] -= amt;
        }
        int cf = coins[0];
        for(int i=1; i< coins.length; i++){
            coins[i] += cf;
            cf = coins[i];
        }
    }
}
