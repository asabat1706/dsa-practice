package Queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class StampString {
    public static void main(String[] args){
        String stamp = "df";
        String target = "dfdff";
        ArrayList<Integer> ans_ind = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Deque<Character> q= new LinkedList<>();

        for(int i=0; i<target.length(); i++){
            sb.append('$');
        }
        while(sb.toString().indexOf('$') > -1){
            int idx = sb.toString().indexOf('$');
            if(sb.length()-idx >= stamp.length()){
                ans_ind.add(idx);
                sb.replace(idx,idx+stamp.length(),stamp);
            }
            else{
                ans_ind.add(sb.length()-stamp.length());
                sb.replace(sb.length()-stamp.length(),sb.length(),stamp);
            }
        }
        for(int i=0; i<sb.length(); i++){
            q.addLast(sb.toString().charAt(i));
        }
        sb = new StringBuilder();
        int idx=0; int index=0;
        while(index < (10*target.length())){
            while(!q.isEmpty() && q.peekFirst() == target.charAt(idx)){
                sb.append(target.charAt(idx));
                q.removeFirst();
                idx++;
            }
            if(sb.toString().equals(target)){
                break;
            }
            int count=0;
            if(!q.isEmpty() && q.peekFirst() != target.charAt(idx)){
                ans_ind.add(idx);
                while(count < stamp.length()){
                    q.removeFirst();
                    count++;
                }
                for(int k=count-1; k>=0; k--){
                    q.addFirst(stamp.charAt(k));
                }
            }
            index++;
        }
        if(sb.toString().equals(target))
        System.out.println(ans_ind);
    }
}
