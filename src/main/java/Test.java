import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args){
//        Integer i = 257;
//        byte b = i.byteValue();
//        System.out.println(b);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(20);
        pq.add(40);
        pq.add(-8);
        pq.add(-33);
        pq.add(100);
        while(!pq.isEmpty()){
            int min = pq.poll();
            System.out.print(min+ "   ");
        }
    }
}
