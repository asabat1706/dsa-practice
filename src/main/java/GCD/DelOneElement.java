package GCD;

public class DelOneElement {
    public static void main(String[] args){
        int[] A= {49,9,12,18,30};
        int[] leftMaxGCD = new int[A.length];
        int[] rightMaxGCD = new int[A.length];
        int g=0,g1=0;
        for(int i=0; i<A.length; i++){
           g = gcd(g,A[i]);
           leftMaxGCD[i] = g;
        }
        for(int i=A.length-1; i>=0; i--){
            g1 = gcd(g1,A[i]);
            rightMaxGCD[i] = g1;
        }
        int max_gcd =0;
        for(int i=0; i<A.length; i++){
            if(i==0) max_gcd = Math.max(max_gcd,gcd(0,rightMaxGCD[i+1]));
            else if(i==(A.length-1)) max_gcd = Math.max(max_gcd, gcd(0,leftMaxGCD[i-1]));
            else max_gcd = Math.max(max_gcd, Math.max(max_gcd, gcd(leftMaxGCD[i-1],rightMaxGCD[i+1])));
        }
        System.out.println("max_gcd "+ max_gcd);
    }
    public static int gcd(int a, int b){
        if(a==0)
            return b;
        return gcd(b%a,a);
    }
}
