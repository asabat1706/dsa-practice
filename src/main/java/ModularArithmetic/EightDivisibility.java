package ModularArithmetic;

public class EightDivisibility {
    public static void main(String[] args){
        String A = "16"; int num=0;
        for(int i=A.length()-1; i>=0; i--){
            int factor = (int) Math.pow(10, A.length()-1-i);
            num = num + Character.getNumericValue(A.charAt(i))*factor;
        }
        System.out.println(num);
        if(num%4==0)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
