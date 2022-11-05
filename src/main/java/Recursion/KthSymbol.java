package Recursion;

public class KthSymbol {
    public static void main(String[] args){
        int A = 20;
        int B= 40;
        System.out.println(formPattern(A,B));
    }

    private static int formPattern(int a,int k) {
        if(a==1)
            return 0;
        else{
            if(k<=(Math.pow(2,(a-1)))/2)
              return formPattern(a-1,k);
            else {
               return 1-formPattern(a-1, (int) (k-((Math.pow(2,(a-1)))/2)));
            }
        }
    }

}
