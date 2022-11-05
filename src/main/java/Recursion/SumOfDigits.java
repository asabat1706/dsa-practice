package Recursion;

public class SumOfDigits {
    public static void main(String[] args){
        int A=1000000000;
        int sum = sumDigits(A,0);
        System.out.println(sum);
    }

    private static int sumDigits(int a, int sum) {
        sum=sum+(a%10) ;
        if(a==0) {
            return sum;
        }
        else
        {
            return sumDigits(a/10,sum);
        }
    }
}
