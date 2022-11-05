package Advanced_Arrays;

import java.util.ArrayList;
import java.util.Stack;

public class InsertInterval {
    public static void main(String[] args){
        ArrayList<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(6,9);
        Interval newInterval = new Interval(2,6);
        intervals.add(i1); intervals.add(i2); intervals.add(newInterval);
        intervals.sort((Interval il, Interval ir) -> il.start-ir.start);
        Stack<Integer> s = new Stack<>();
        s.push(intervals.get(0).start);
        s.push(intervals.get(0).end);
        for(int i=1; i<intervals.size(); i++){
            int p = s.peek();
            if(intervals.get(i).start <= p && intervals.get(i).end > p) {
                s.pop();
                s.push(intervals.get(i).end);
            }
            else if(intervals.get(i).end <= p){
                continue;
            }
            else
            {
                s.push(intervals.get(i).start);
                s.push(intervals.get(i).end);
            }
        }
        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        while(!s.isEmpty()){
            int e = s.pop();
            int b = s.pop();
            Interval inter = new Interval(b,e);
            mergedIntervals.add(0,inter);
        }
        for(Interval i : mergedIntervals)
            System.out.println(i.start + " " + i.end);
    }

}
