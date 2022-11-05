package Sorting;

public class MaxMod {
    public static void main(String[] args){
        int[] A = {1,2,3,3};
        int max_ele=A[0], sec_max=A[0];
        for(int i=1; i<A.length; i++){
            if((A[i] > max_ele)) {
                sec_max = max_ele;
                max_ele = A[i];
            }
            else if((A[i] > sec_max) && (max_ele != A[i])){
                sec_max=A[i];
            }
        }
        System.out.println(max_ele + "  "+  sec_max);
    }
}
