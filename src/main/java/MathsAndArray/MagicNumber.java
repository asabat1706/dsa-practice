package MathsAndArray;

public class MagicNumber {
    public static void main(String[] args){
        int A = 5;
        int ans=0; int power=1;
        while(A>0){
            if((A&1) == 1){
                ans = (int) (ans + Math.pow(5,power));
            }
            power = power+1;
            A = A>>1;
        }
        System.out.println(ans);
    }
}
