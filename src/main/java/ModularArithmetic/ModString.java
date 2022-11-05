package ModularArithmetic;

public class ModString {
    public static void main(String[] args){
        String A = "43535321";
        int B = 47;
        long num=0; int value=0; long factor=1;
        for(int j=A.length()-1; j>=0; j--) {
            if(j!= A.length()-1) factor = (factor%B) * (10%B);
            int e = A.length()-1-j;
            num = (num%B) + ((Character.getNumericValue(A.charAt(j))%B) * (factor));
        }
        value = (int) (num%B);
        System.out.println(value);

    }
}
