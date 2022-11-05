package Recursion;

public class SeqProb {
    public static void main(String[] args){
        int A = 3;
        int ans = solve(A);
        System.out.println(ans);
    }

    private static int solve(int a) {
        if(a==0) return 1;
        else if(a==1) return 1;
        else if(a==2) return 2;
        else
            return solve(a-1)+solve(a-2)+solve(a-3)+a;
    }
}
