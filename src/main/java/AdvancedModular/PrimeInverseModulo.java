package AdvancedModular;

public class PrimeInverseModulo {
    public static void main(String[] args){
//        int A=1525, B=999996223; int ans=0;
        int A=10042625, B=55557217; int ans=0;
        if(B>2){
          long p = solve(A,B-2, B);
            System.out.println(p);
          ans = (int)(p%B);
        }
        else {
            for (int i = 0; i < B; i++) {
                if ((((long) (A % B) * i) % B) == 1L)
                    ans = i;
            }
        }
        System.out.println(ans);
    }

    private static long solve(int a, int i, int mod) {
        if(i == 1) return a;
        long pow = solve(a, i/2, mod);
        if(i%2 == 0)
            return ((pow%mod)*(pow%mod))%mod;
        else return ((a%mod)*(pow%mod)*(pow%mod))%mod;
    }
}
