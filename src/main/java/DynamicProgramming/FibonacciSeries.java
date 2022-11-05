package DynamicProgramming;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[] memo_arr = new int[input+1];
        memo_arr[0] = 0;
        memo_arr[1] = 1;
        for(int i=2; i<= input; i++){
            memo_arr[i] = memo_arr[i-1] + memo_arr[i-2];
        }
        System.out.println(memo_arr[input]);
    }
}
