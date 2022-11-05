import java.util.ArrayList;
import java.util.Scanner;

public class IsPerfectPrime {
     public static void main(String[] args){
         int sum=0; int N = 6;
             for(int i=2; i<= Math.sqrt(N); i++)
             {
                 if(N%i == 0)
                     sum = sum + (N/i) + i;
             }
             sum = sum+1;
             if(sum == N) System.out.println("YES");
             else System.out.println("NO");

         }
     }

