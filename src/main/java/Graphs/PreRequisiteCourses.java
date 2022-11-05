package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PreRequisiteCourses {
    static ArrayList<LinkedList<Integer>> preRequisiteList = new ArrayList<>();
    static int[] preRequites;
    public static void main(String[] args){
        int courses = 3;
        int[][] pre_req = {{1,2},{2,1}};
        preRequites = new int[courses+1];
        preRequites[0] = -1;
        createAdjacencyList(courses,pre_req);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<preRequites.length; i++){
            if(preRequites[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
           Integer course = queue.poll();
           LinkedList<Integer> next_courses = preRequisiteList.get(course);
           for(int i=0; i<next_courses.size(); i++){
               Integer next_course = next_courses.get(i);
               preRequites[next_course]--;
               if(preRequites[next_course] == 0){
                   queue.add(next_course);
               }
           }
        }
        int isPossible = 1;
        for(int i=0; i< preRequites.length; i++){
            if(preRequites[i] > 0){
                isPossible=0;
                break;
            }
        }
        System.out.println(isPossible);
    }

    private static void createAdjacencyList(int courses, int[][] pre_req) {
        for(int i=0; i<= courses; i++){
            LinkedList<Integer> pre_req_course = new LinkedList<>();
            preRequisiteList.add(pre_req_course);
        }
        for(int i=0; i< pre_req.length; i++){
            LinkedList<Integer> pre_req_course = preRequisiteList.get(pre_req[i][0]);
            pre_req_course.add(pre_req[i][1]);
            preRequisiteList.set(pre_req[i][0],pre_req_course);
            preRequites[pre_req[i][1]]++;
        }
    }
}
