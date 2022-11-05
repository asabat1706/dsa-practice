package Stacks;

import java.util.Stack;

public class HistogramMaxArea {
    public static void main(String[] args){
//        int[] A = {3,2,4,1,5,2};
//        int[] A = {2, 1, 5, 6, 2, 3};
//        int[] A = {47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27};
//        int[] A = {1};
//        int[] A = {69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27};
        int[] A = {17, 91, 27, 4, 80, 78};
        int[] nsel = new int[A.length];
        int[] nser = new int[A.length];
        Stack<Integer> indices = new Stack<>();
        nsel[0] = -1;
        indices.push(0);
        int index = 1;
        for(int i=1; i<A.length; i++){
            while(!indices.isEmpty() && A[indices.peek()] >=A[i]){
                indices.pop();
            }
            if(indices.isEmpty()){
                nsel[index++] = -1;
            }
            else{
                nsel[index++] = indices.peek();
            }
            indices.push(i);
        }
        indices.clear();
        index=A.length-2;
        nser[A.length-1] = A.length;
        indices.push(A.length-1);
        for(int i=A.length-2; i>=0; i--){
            while(!indices.isEmpty() && A[indices.peek()] >= A[i]){
                indices.pop();
            }
            if(indices.isEmpty()){
                nser[index--] = A.length;
            }
            else{
                nser[index--] = indices.peek();
            }
            indices.push(i);
        }
        for(int i=0; i<A.length; i++){
            System.out.print(nsel[i] + "  ");
        }
        System.out.println("  ");
        for(int i=0; i<A.length; i++){
            System.out.print(nser[i] + "  ");
        }
        System.out.println("   ");
        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            int area;
            if(A.length==1)
                area = A[0];
            else {
                int base=1;
                if((nsel[i]==-1) && (nser[i]==-1)) base = A.length;
                 else{
                     int basel = i - nsel[i];
                     int baser = nser[i] - i;
                     base = basel+baser-1;
                }
                area = base * A[i];
            }
            max = Math.max(max,area);
        }
        System.out.println(max);
    }
}
