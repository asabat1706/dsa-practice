package MultiThreadingPrograms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args){
        Runnable[] jobs = {
                new PrintJob("job 1"),
                new PrintJob("job 2"),
                new PrintJob("job 3"),
                new PrintJob("job 4")
        };
        ExecutorService service  = Executors.newFixedThreadPool(3);
        for(Runnable job: jobs){
            service.submit(job);
        }
    }


}
class PrintJob implements Runnable{
    String jobName;

    public PrintJob(String jobName){
        this.jobName = jobName;
    }

    public void run(){
        System.out.println(" Job " + jobName + " started by "+ Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){

        }
        System.out.println(" Job " + jobName + " completed by "+ Thread.currentThread().getName());
    }

}
