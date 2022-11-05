import java.util.Scanner;

public class Armstrong {
        public static void main(String[] args) {
            // YOUR CODE GOES HERE
            // Please take input and print output to standard input/output (stdin/stdout)
            // DO NOT USE ARGUMENTS FOR INPUTS
            // E.g. 'Scanner' for input & 'System.out' for output
            int N = 200; int count=0;
            for(int i = 1; i <= N; i++)
            {
                int num = i;
                int sum = 0;
                while(num > 0){
                    int r1 = num%10;
                    sum = sum+ (r1*r1*r1);
                    num=num/10;
                }
                if(sum == i)
                    count++;
            }
            System.out.println(count);
        }

}
