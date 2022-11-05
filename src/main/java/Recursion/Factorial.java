package Recursion;

public class Factorial {
    public static void main(String[] args){
        int N=1;
        System.out.println(factorial(N));
    }

    private static int factorial(int n) {
        if(n==0) return 1;
        else if(n==1)
            return 1;
        else
            return factorial(n-1) * n;
    }
}
