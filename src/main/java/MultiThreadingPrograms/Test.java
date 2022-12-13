package MultiThreadingPrograms;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        Integer i = 257;
//        byte b = i.byteValue();
//        System.out.println(b);

//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(20);
//        pq.add(40);
//        pq.add(-8);
//        pq.add(-33);
//        pq.add(100);
//        while(!pq.isEmpty()){
//            int min = pq.poll();
//            System.out.print(min+ "   ");
//        }
        PrintTotal p = new PrintTotal(11);
        Thread t1 = new Thread(p::printOddNumbers);
        Thread t2 = new Thread(p::printEvenNumbers);
        t1.start();
        t2.start();
    }
}

class PrintTotal{
    int total=0;
    int current = 0;

    public PrintTotal(int total){
        this.total=total;
    }

    public void printOddNumbers()
    {
            synchronized (this) {
                while(current < total) {
                    if(current%2==0){
                    try {
                        wait();
                    } catch (InterruptedException ex) {

                    }
                   }
                    else {
                        System.out.println(current);
                        current++;
                        notify();
                    }
                }
            }
    }

    public void printEvenNumbers(){
            synchronized (this) {
                while(current < total) {
                    if (current % 2 != 0) {
                        try {
                            wait();
                        } catch (InterruptedException ex) {

                        }
                    } else {
                        System.out.println(current);
                        current++;
                        notify();
                    }
                }
        }
    }

}
