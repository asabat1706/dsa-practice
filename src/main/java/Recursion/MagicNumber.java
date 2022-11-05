package Recursion;

public class MagicNumber {
    public static void main(String[] args){
        int A=1000000000;
        int isMagic = magicSum(A,0);
        System.out.println(isMagic);
    }

    private static int magicSum(int a, int sum) {
        if(a==0){
            if(sum<10)
                if(sum == 1)
                    return 1;
                else return 0;
            return magicSum(sum,0);
        }
        else{
            sum = sum+a%10;
            sum = magicSum(a/10,sum);
            return sum;
        }
    }
}
