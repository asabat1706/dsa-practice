package DynamicProgramming;

public class Staircase {
    public static void main(String[] args){
        int no_steps =46312;
        int ans = climbStairs(no_steps);
        System.out.println(ans);
    }
    public static int climbStairs(int A) {
        int mod = 1000000007;
        long[] steps = new long[A+1];
        steps[0] = 0L;
        if(A==0) return 0;
        steps[1] = 1L;
        if(A==1) return 1;
        steps[2] = 2L;
        for(int i=3; i<= A; i++){
            steps[i] = ((steps[i-1]%mod) + (steps[i-2]%mod)%mod);
        }
        return (int)(steps[A]%mod);
    }
}
