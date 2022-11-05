package Stacks;

import java.util.Stack;

public class NearestSmallesElement {
    public static void main(String[] args){
        int[] A = {34, 35, 27, 42, 5, 28, 39, 20, 28};
        int[] ans = new int[A.length];
        int index=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<A.length; i++){
            if(! st.isEmpty()){
                if(st.peek() < A[i]){
                    ans[index] = st.peek();
                    st.push(A[i]);
//                    continue;
                }
                else{
                    while (st.peek() > A[i]){
                        st.pop();
                    }
                    if(!st.isEmpty()){
                        ans[index] = st.peek();
                        st.push(A[i]);
//                        continue;
                    }
                    else{
                        st.push(A[i]);
                        ans[index] = -1;
                    }
                }
            }
            else{
                st.push(A[i]);
                ans[index] = -1;
            }
            index++;
        }

        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+ "   ");
        }
    }
}
