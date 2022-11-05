package Recursion;

public class PowFunction {
    public static void main(String[] args){
        int x=71045970,n=41535484,d=64735492;
        int op = findPowMod(x,n,d);
        System.out.println(op);
    }

    private static int findPowMod(int x, int n, int d) {
        if(n==1){
            return x%d;
        }
        int p = findPowMod(x,n/2,d);
        long p_2 = ((long)(p%d)*(p%d))%d;
        if((n&1)==1){
            int ans = (int)((x%d)*(p_2)%d);
            return ans;
        }
        else{
            int ans = (int)(p_2%d);
            return ans;
        }
    }
}
