package DSCarryForward;

public class EvenLengthEvenNumber {
    public static void main(String[] args){
//        int A[] = { 121, 351, 314, 562, 953, 319, 859, 413, 201, 640, 66, 723, 998, 612, 291, 539, 463, 340, 64, 251, 807, 457, 584, 944, 315, 327, 769, 675, 113, 364, 488, 579, 674, 340, 950, 516, 618, 599, 186, 496, 403, 450, 833, 79, 229, 150, 497, 256, 971, 687, 318, 717, 540, 126, 906, 843, 417, 557, 97, 370, 409, 148, 968, 562, 534, 845, 378};
        int A[] = {2,4,6,8};
        int eve_index=-1; int count[]= new int[A.length/2];
        for(int i=0; i<A.length; i++){
            int j=0;
            if(A[i]%2==0)
                if(eve_index==-1) eve_index=i;
                else{
                   int l= i-eve_index;
                   if((l+1)%2==0) {
                       count[j]=l+1;
                       j++;
                   }
                }
        }
        int sum=0;
        for(int i=0; i< count.length; i++){
            sum = sum+ count[i];
        }
        if(sum==A.length) System.out.println("YES");
        else System.out.println("NO");
    }
}
