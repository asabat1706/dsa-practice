package Recursion;

public class KSymbol {
    public static void main(String[] args){
        int A = 2; int B=2;
        int num = findSymbol(A,B);
        System.out.println(num);
    }

    private static int findSymbol(int a, int b) {
        if(a==1) return 0;
        else{
            int x = findSymbol(a-1,(b+1)/2);
            if((b&1) == 1) return x;
            else return 1-x;
        }
    }
}
