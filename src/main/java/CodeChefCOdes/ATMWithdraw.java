package CodeChefCOdes;

import java.util.Scanner;

public class ATMWithdraw {

    public static void withdraw(double amt, double bal){
        if(amt%5==0){
            double total_amt  = amt+0.50;
            if(total_amt <= bal){
                System.out.println(bal-total_amt);
            }
            else
                System.out.println(bal);
        }
        else
            System.out.println(bal);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        double balance = sc.nextDouble();
        withdraw(amount,balance);
    }
}
