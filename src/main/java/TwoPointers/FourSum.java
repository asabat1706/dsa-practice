package TwoPointers;

import java.util.*;

public class FourSum {
    public static void main(String[] args){
        int[] input = {1, 0, -1, 0, -2, 2};
        ArrayList<ArrayList<Integer>> ans_list= new ArrayList<>();
        int target = 0;
        Arrays.sort(input);
        for(int i=0; i< input.length;i++){
            for(int j=i+1; j< input.length; j++){
                HashSet<Integer> temp_ans = new HashSet<>();
                int x = j+1;
                int y = input.length-1;
                while(x<y){
                    if((input[i]+input[j]+input[x]+input[y]) < target){
                       x++;
                    }
                    else if((input[i]+input[j]+input[x]+input[y]) > target){
                        y--;
                    }
                    else{
                        int count=0;
                        ArrayList<Integer> list = new ArrayList<>();
                        if(!temp_ans.contains(input[i])){
                            temp_ans.add(input[i]);
                        }else{
                            count++;
                        }
                        if(!temp_ans.contains(input[j])){
                            temp_ans.add(input[j]);
                        }
                        else {
                            count++;
                        }
                        if(!temp_ans.contains(input[x])){
                            temp_ans.add(input[x]);
                        }
                        else{
                            count++;
                        }
                        if(!temp_ans.contains(input[y])){
                            temp_ans.add(input[y]);
                        }
                        else{
                            count++;
                        }
                        if(count != temp_ans.size()) {
                            list.add(input[i]);
                            list.add(input[j]);
                            list.add(input[x]);
                            list.add(input[y]);
                            ans_list.add(list);
                        }
                        x++; y--;
                    }
                }
            }
        }
        int[][] ans = new int[ans_list.size()][];
        Iterator itr = ans_list.iterator();
        int i=0;
        while(itr.hasNext()){
           ArrayList<Integer> l = (ArrayList<Integer>) itr.next();
           ans[i] = new int[l.size()];
           for(int j = 0; j<l.size(); j++){
               ans[i][j] = l.get(j);
           }
           i++;
        }
        System.out.println(ans_list);
    }
}
