package InterviewProblems;

import java.util.ArrayList;
import java.util.List;

public class MaximumPositivity {
    public static void main(String[] args){
        int B[] = {8986143, -5026827, 5591744, 4058312, 2210051, 5680315, -5251946, -607433, 1633303, 2186575};
        int A[] = new int[B.length+1];
        for(int i=0; i<B.length; i++){
            A[i] = B[i];
        }
        A[B.length]=-1;
        List<Integer> pre_list = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<A.length; i++){
            if(A[i]<0){
                if(list.size()>pre_list.size())
                    pre_list = list;
                list = new ArrayList<>();
            }
            else
                list.add(A[i]);
        }
        System.out.println(pre_list);
        int C[] = new int[pre_list.size()];
        for(int i=0; i<pre_list.size(); i++){
            C[i]=pre_list.get(i);
        }
    }
}
