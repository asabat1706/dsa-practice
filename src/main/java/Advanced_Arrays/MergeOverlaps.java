package Advanced_Arrays;

import java.util.ArrayList;
import java.util.Stack;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }

public class MergeOverlaps {
    public static void main(String[] args){
        Interval i1 = new Interval(1,10);
        Interval i2 = new Interval(2,9);
        Interval i3 = new Interval(3, 8);
        Interval i4 = new Interval(4,7);

        ArrayList<Interval> intervals = new ArrayList<>();
        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        intervals.add(i1);intervals.add(i2);intervals.add(i3);intervals.add(i4);

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
