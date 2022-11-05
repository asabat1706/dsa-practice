package ModularArithmetic;

public class ABModulo {
    public static void main(String[] args){
        int A = 7346582, B=7035106;
        int num =0;
        if(A<B){
            for(int i=1; i<=B; i++){
                if((A%i) == (B%i)) {
                    num = Math.max(num,i);
                }
            }
        }
        else{
            for(int i=1; i<=A; i++){
                if(A%i == B%i) {
                    num = Math.max(num,i);
                }
            }
        }
        System.out.println(num);
    }
}
