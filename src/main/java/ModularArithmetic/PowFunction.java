package ModularArithmetic;

public class PowFunction {
    public static void main(String[] args){
        int A = 90752123, B=47261846, C = 38742364;
//        int A=2, B=3, C=3;
        long ans = pow(A,B,C)%C;
        if(ans < 0) ans = (C+ans)%C;
        System.out.println((int)(ans%C));
    }

    private static long pow(int i, int i1, int i2) {
        if(i1==0)
            return 1;
        else {
            long x = pow(i, i1 / 2, i2);
            if (i1 % 2 == 0) {
                return (x%i2 * x%i2)%i2;
            } else {
                long y = (i%i2 * x%i2)%i2;
                return (y%i2 * x%i2)%i2;
            }
        }


    }
}
