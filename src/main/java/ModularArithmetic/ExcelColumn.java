package ModularArithmetic;

public class ExcelColumn {
    public static void main(String[] args){
        String A = "ABCD"; int value=0;
        for(int i=A.length()-1; i>=0; i--){
            int ch = (A.charAt(i)%65)+1;
            int factor = (int) Math.pow(26,A.length()-1-i);
            value = value+ch*factor;
        }
        System.out.println(value);
    }
}
