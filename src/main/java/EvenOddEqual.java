import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenOddEqual {
    public static void main(String[] args){
        int A[]={1,2,6,4};
        List L = new ArrayList();
        for(int t=0; t<A.length; t++)
            L.add(A[t]);
        int count=0;
        for(int i=0; i<A.length; i++){
            int temp = (int) L.get(i);
            L.remove(i);
            int PSE[] = new int[L.size()];
            int PSO[] = new int[L.size()];
            PSE[0] = (int) L.get(0);
            for(int j=1; j<L.size(); j++){
                if(j%2==0) {
                    PSE[j] = (int)L.get(j) + PSE[j - 1];
                    PSO[j] = PSO[j-1];
                }
                else {
                    PSO[j] = (int)L.get(j) + PSO[j - 1];
                    PSE[j] = PSE[j-1];
                }
            }
            if(PSE[L.size()-1] == PSO[L.size()-1])
                count++;
            L.add(i,temp);
        }
        System.out.println("count = " + count);
    }
}

//{
//        int A[]={1,1,1};
//        int count=0;
//        for(int i=0; i<A.length; i++){
//            int PSE[] = new int[A.length];
//            int PSO[] = new int[A.length];
//            int temp = A[i];
//            A[i] = 0;
//            PSE[0] = A[0];
//            for(int j=1; j<A.length; j++){
//                if(j%2==0) {
//                    PSE[j] = A[j] + PSE[j - 1];
//                    PSO[j] = PSO[j-1];
//                }
//                else {
//                    PSO[j] = A[j] + PSO[j - 1];
//                    PSE[j] = PSE[j-1];
//                }
//            }
//            if(PSE[A.length-1] == PSO[A.length-1])
//                count++;
//            A[i] = temp;
//        }
//        System.out.println("count = " + count);
//    }
