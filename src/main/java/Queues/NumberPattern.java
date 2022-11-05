package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class NumberPattern {
    public static void main(String[] args){
        int A = 7;
        int[] num = generatePattern(A);
        for(int i=0; i<num.length; i++){
            System.out.print(num[i]+"  ");
        }
    }

    private static int[] generatePattern(int num) {
        int[] ans = new int[num];
        Queue<Integer> q = new LinkedList<>();
        int index=0;
        q.add(1); ans[index]=1;
        if(index==(num-1)) return ans;
        index++;
        q.add(2); ans[index]=2;
        if(index==(num-1)) return ans;
        index++;
        q.add(3); ans[index]=3;
        if(index==(num-1)) return ans;
        index++;
        while(index < num && (!q.isEmpty())){
            int ele = q.peek();
            int first_ele = (ele*10)+1;
            q.add(first_ele); ans[index]=first_ele;
            if(index==(num-1)) return ans;
            index++;
            int second_ele = (ele*10)+2;
            q.add(second_ele); ans[index]=second_ele;
            if(index==(num-1)) return ans;
            index++;
            int third_ele = (ele*10)+3;
            q.add(third_ele); ans[index]=third_ele;
            if(index==(num-1)) return ans;

            q.remove();
            index++;
        }
        return ans;
    }
}
