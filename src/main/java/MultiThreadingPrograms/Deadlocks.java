package MultiThreadingPrograms;

public class Deadlocks {
    public static void main(String[] args){
        Thread1Task task1 = new Thread1Task();
        Thread2Task task2 = new Thread2Task();
        Thread t1 = new Thread(()->task1.execute(task2));
        Thread t2 = new Thread(()->task2.execute(task1));
        t1.start();
        t2.start();
    }
}
class Thread1Task{
    public synchronized void execute(Thread2Task t){
        System.out.println(Thread.currentThread().getName() + " is calling " + t.getClass().getName());
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){

        }
        t.test();
    }
    public synchronized void test(){

    }
}
class Thread2Task{
    public synchronized void execute(Thread1Task t){
        System.out.println(Thread.currentThread().getName() + " is calling " + t.getClass().getName());
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){

        }
        t.test();
    }
    public synchronized void test(){

    }
}
