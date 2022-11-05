package GCD;

public class Pubg {
    public static void main(String[] args){
        int[] A = {48, 96, 32, 36};
        int g = gcd(A[0],A[1]);
        int ans = g;
        for(int i=2; i<A.length; i++){
             g = gcd(g,A[i]);
            ans=Math.min(ans,g);
        }
        System.out.println(ans);
    }

    public static int gcd(int a, int b) {
        if(a==0)
            return b;
        return gcd(b%a,a);
    }
}
