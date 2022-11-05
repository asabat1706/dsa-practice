package Queues;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class NPerfectNumber {
    public static void main(String[] args){
        int A = 100000;
        Queue<Long> q = new LinkedList();
        long n_num = generatePatter(q,A);
        long rev_num = generateRev(n_num);
        System.out.println(n_num + "  "+ rev_num);
    }

    private static long generateRev(long n_num) {
        long num = n_num; long rev=0;
        while(num>0){
            rev = (rev*10)+(num%10);
            num = num/10;
        }
        return rev;
    }

    private static long generatePatter(Queue<Long> q, int a) {
        int count=0;
        q.add(1L);
        count++;
        if(count==a) return 1;
        q.add(2L);
        count++;
        if(count==a) return 2;
        while(!q.isEmpty() && count<a){
            long ele = q.peek();
            long first_num = ele*10+1;
            q.add(first_num);
            count++;
            if(count==a) return first_num;
            long sec_num = ele*10+2;
            q.add(sec_num);
            count++;
            if(count==a) return sec_num;
            q.remove();
        }
        return count;
    }
}
