package Recursion;

public class Fibonacci {
    public static void main(String[] args){
        int A=9;
        System.out.println(findAthFibonacci(A));
    }

    private static int findAthFibonacci(int a) {
        if(a==0)
            return 0;
        else if(a==1)
            return 1;
        else
            return findAthFibonacci(a-1)+findAthFibonacci(a-2);
    }
}
