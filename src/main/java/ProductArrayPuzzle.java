public class ProductArrayPuzzle {
    public static void main(String[] args){
        int A[] = {1,2,3,4};
        int B[] = new int[A.length];
        int prod = 1;
        for(int i=0; i < A.length; i++){
            prod = prod * A[i];
        }
        for(int i=0; i< A.length; i++)
        {
            B[i] = prod / A[i];
            System.out.print(B[i]+ " ");
        }
    }
}
