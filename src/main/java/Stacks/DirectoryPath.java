package Stacks;

import java.util.Stack;

public class DirectoryPath {
    public static void main(String[] args){
        String A = "/../";
        StringBuilder ans = new StringBuilder("/");
        String[] singlepaths = A.split("/");
        Stack<String> st = new Stack<>();
        for(int i=0; i<singlepaths.length; i++){
            if(!singlepaths[i].equals(".") && !singlepaths[i].equals("..") && !singlepaths[i].equals("")){
               st.push(singlepaths[i]);
               st.push("/");
            }
            else if(singlepaths[i].equals("..") && !st.isEmpty()){
                st.pop();
                st.pop();
            }
            else continue;
        }
        if(!st.isEmpty() && st.peek().equals("/")) st.pop();
        for(String s : st){
            StringBuilder temp = new StringBuilder(s);
            ans.append(temp);
        }
        System.out.println(ans);
    }
}
