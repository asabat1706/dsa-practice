public class EquillibriumIndex {
    public static void main(String[] args){
        int A[] = {1,2,3,4};
        int PS[] = new int[A.length];
        PS[0] = A[0];
        for(int i=1; i<A.length; i++){
            PS[i] = A[i] + PS[i-1];
        }
        int SL=0, SR=0;
        for(int i=0; i< A.length; i++) {
            if (i == 0)
                SL = 0;
            else
                SL = PS[i - 1];
            if (i == (A.length - 1))
                SR = 0;
            else
                SR = PS[A.length - 1] - PS[i];

            if (SL == SR) {
                System.out.println(i);
                break;

            }
        }
    }
}
