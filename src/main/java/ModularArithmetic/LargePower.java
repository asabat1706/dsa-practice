package ModularArithmetic;

public class LargePower {
    public static void main(String[] args){
        int A=35, B=68, mod=1000000007;
        long fact=1;
        for(int i=2; i<=B; i++){
            fact= (fact%(mod-1) * i%(mod-1))%(mod-1);
        }
        long ans = pow(A,fact,mod);
        if(ans < 0) ans = mod+ans;
        System.out.println((int)(ans%mod));
    }

    private static long pow(long a, long fact, int mod) {
        if(fact==1) return a;
        else{
            long x = pow(a,fact/2, mod);
            long y = ((x%mod) * (x%mod))%mod;
            if(fact%2 == 0) return y%mod;
            else return ((a%mod) * (y%mod))%mod;
        }
    }
}
