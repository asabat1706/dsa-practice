package Recursion;

import java.util.ArrayList;

public class GrayCodeRec {
    public static void main(String[] args){
        int a = 3;
        ArrayList<String> binaryGray = grayCode(a);
        ArrayList<Integer> binaryToDec = convert(binaryGray);
        System.out.println(binaryGray);
        System.out.println(binaryToDec);
    }

    private static ArrayList<Integer> convert(ArrayList<String> binaryGray) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(String a : binaryGray){
            Integer i = Integer.parseInt(a,2);
            ans.add(i);
        }
        return ans;
    }

    private static ArrayList<String> grayCode(int a) {
        if(a==0) return null;
        else if(a==1) {
            ArrayList<String> l = new ArrayList<>();
            l.add("0"); l.add("1");
            return l;
        }
        else{
            ArrayList<String> l = grayCode(a-1);
            ArrayList<String> ans = new ArrayList<>();
            for(int i=0; i<l.size(); i++){
                ans.add("0" +l.get(i));
            }
            for(int i=l.size()-1; i>=0; i--){
                ans.add("1" +l.get(i));
            }
            return ans;
        }
    }
}
