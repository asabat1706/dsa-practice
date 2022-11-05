package Sorting;

public class Test {
    public static void main(String[] args){
        int[] A = {1,2,3,4};
        for(int i=0; i<32; i++){
            for(int j=0; j<A.length; j++){
                if((A[j]>>i & 1) > 0){
                    System.out.print("include " +A[j] +" ");
                }
                else{
                    System.out.print("not include "+A[j]+" ");
                }
            }
            System.out.println();
        }

        System.out.println(42.25%10);
    }
}
