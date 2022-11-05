package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonElements2 {
    public static void main(String[] args){
        int[] arr1 = {2, 1, 4, 10};
        int[] arr2 = {3, 6, 2, 10, 10};
        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> common_elements = new HashMap<>();
        for(int i=0; i<arr1.length; i++){
            if(!common_elements.containsKey(arr1[i])){
                common_elements.put(arr1[i],1);
            }
            else{
                common_elements.put(arr1[i],common_elements.get(arr1[i])+1);
            }
        }

        for(int i=0; i<arr2.length; i++){
            if(common_elements.containsKey(arr2[i]))
            {
                ans.add(arr2[i]);
                int freq = common_elements.get(arr2[i])-1;
                if(freq == 0){
                    common_elements.remove(arr2[i]);
                }
                else{
                    common_elements.put(arr2[i],freq);
                }
            }
        }
        int[] ans_arr = new int[ans.size()];
        int index=0;
        for(Integer e : ans){
            ans_arr[index++] = e;
        }
        for(int i=0; i< ans_arr.length; i++) {
            System.out.print(ans_arr[i] + "  ");
        }
    }
}
