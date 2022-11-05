package Recursion;

public class PowFunc {
    public static void main(String[] args){
        int A=2, B=3, C=3;
        long ans = pow(A,B,C);
        if(ans < 0) ans = C+ans;
        System.out.println((int)(ans%C));
    }

    private static long pow(int a, int b, int c) {
        if(b==1) return a%c;
        long x = pow(a,b/2,c);
        long y = (x%c * x%c)%c;
        if(b%2 == 0) return y%c;
        else return ((a%c)*(y%c))%c;
    }
}
