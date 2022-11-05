package Strings;

public class Tester {
    public static void main(String[] args){
        char A[] = {'A','a','Z','z','#'};
        for(int i=0; i<A.length; i++){
            if(A[i]>='A' && A[i]<='Z')
                A[i] = (char) (A[i] +(int)('a'-'A'));
        }
        for(int i=0; i<A.length; i++){
            System.out.print(A[i]+" ");
        }
        String s="test";

    }
}
