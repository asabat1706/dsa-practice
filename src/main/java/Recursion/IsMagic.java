package Recursion;

public class IsMagic {

    public static void main(String[] args){
        int A = 83557;
        boolean isMagic = magic(A);
        System.out.println(isMagic);
    }

    private static boolean magic(int s) {
        if(s<10) return false;
        else if(s==10) return true;
        else {
            int sum1 = sum(s);
            return magic(sum1);
        }
    }

    private static int sum(int a) {
        if(a == 0) return 0;
        else{
            int q = a/10;
            int r = a%10;
            return (r + sum(q));
        }
    }
}
