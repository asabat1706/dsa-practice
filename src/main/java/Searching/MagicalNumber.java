package Searching;

public class MagicalNumber {
    static int mod = 1000000007;
    public static void main(String[] args){
        int A = 807414236, B= 3788, C=38141;
        long s = 2, e = (Math.min(B,C)*(long)A);
        int ans=-1;
        while(s <= e){
            long mid = s + (e-s)/2;
            long count = countMultiples(mid, B, C);
            if(count == A){
                if((mid%B == 0) || (mid%C == 0)) {
                    ans = (int) (mid % mod);
                    break;
                }
                else{
                    long temp1 = mid%B;
                    long temp2 = mid%C;
                    ans = (int)((mid - Math.min(temp1,temp2))%mod);
                    break;
                }
            }
            else{
                if(count > A){
                    e = mid - 1;
                }
                else{
                    s = mid+1;
                }
            }
        }
        System.out.println(ans);
    }

    private static long countMultiples(long mid, int B, int C) {
        long noOfMultiplesofB = mid/B;
        long noOfMultiplesofC = mid/C;
        long BNC = (long)B*C;
        long gcd = findgcd(B,C);
        long lcm = BNC / gcd;
        long multiplesOfBNC = mid/lcm;
        return (noOfMultiplesofB+noOfMultiplesofC-multiplesOfBNC);
    }

    private static long findgcd(int b, int c) {
        if(b==0) return c;
        else return findgcd(c%b,b);
    }
}
