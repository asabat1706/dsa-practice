package PermutationAndCombination;

public class NCR {
    public static void main(String[] args){
        int A=51299,B=25646,C=3685739;
        long a = fact(A,C);
        long b = fact(A-B,C);
        long bpower = 0;
        if(C <= 2)  bpower = pow(b,C);
        else bpower = fastpow(b,C-2, C);
        long c = fact(B,C);
        long cpower = 0;
        if(C <= 2)  cpower = pow(b,C);
        else cpower = fastpow(c,C-2, C);
        long ans = ((a%C) * (bpower%C))%C;
         ans = ((ans%C)* (cpower%C))%C;
        if(ans < 0) ans = C+ans;
        System.out.println((int)ans%C);
    }

    private static long pow(long b, int c) {
        for(long i=1; i<=c; i++){
            if(((b%c) * i)%c == 1)
                return i;
        }
        return 0;
    }

    private static long fastpow(long b, int p, int c) {
        if(p==1)
            return b%c;
        long x = fastpow(b,p/2, c);
        long y = (x%c * x%c)%c;
        if(p%2==0) return y;
        else return (y%c * b%c)%c;
    }

    private static long fact(int a, int c) {
        if(a==0) return 0;
        long fact = 1;
        for(int i=2; i<=a; i++){
            fact = (fact%c * i%c)%c;
        }
        return fact;
    }
}
