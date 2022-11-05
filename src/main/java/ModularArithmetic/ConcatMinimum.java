package ModularArithmetic;

public class ConcatMinimum {
    public static void main(String[] args){
        int A=57, B=91, C=91;
        String sum="";
        if(A <= B && C <= B){
            if(A <= C) {
                sum = sum + A;
                sum = sum + C;
            }
            else {
                sum = sum + C;
                sum = sum + A;
            }
            sum = sum + B;
        }
        else if(B <= C && A <= C){
            if(B <= A) {
                sum = sum + B;
                sum = sum + A;
            }
            else {
                sum = sum + A;
                sum = sum + B;
            }
            sum = sum + C;
        }
        else{
            if(B <= C) {
                sum = sum + B;
                sum = sum + C;
            }
            else {
                sum = sum + C;
                sum = sum + B;
            }
            sum = sum + A;
        }
        System.out.println(Integer.parseInt(sum));
    }
}
