package Recursion;

import java.util.ArrayList;

public class TowerOfHanoi {
    public static void main(String[] args){
        int A=3;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        al = towerOfHanoi(A,al,1,2,3);
        System.out.println(al);
    }

    private static ArrayList<ArrayList<Integer>> towerOfHanoi(int a, ArrayList<ArrayList<Integer>> al, int src, int inter, int dest) {
      if(a==1){
          ArrayList<Integer> list = new ArrayList<>();
          list.add(a); list.add(src); list.add(dest);
          al.add(list);
          return al;
      }
        towerOfHanoi(a-1,al,src,dest,inter);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a); list.add(src); list.add(dest);
        al.add(list);
        towerOfHanoi(a-1,al,inter,src,dest);
        return al;
    }
}
