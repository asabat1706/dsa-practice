package MultiThreadingPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Sorter implements Callable<List<Integer>> {

    List<Integer> input_vals = new ArrayList<>();
    List<Integer> sorted_vals = new ArrayList<>();

    public Sorter(List<Integer> input_vals){
        this.input_vals = input_vals;
        sorted_vals.addAll(input_vals);
    }

    @Override
    public List<Integer> call() throws Exception {
        mergeSortAlgo(input_vals, 0, input_vals.size()-1);
        return sorted_vals;
    }

    private void mergeSortAlgo(List<Integer> input_vals, int start, int end) throws ExecutionException, InterruptedException {
        if(end <= start){
            return;
        }
        int mid = start + (end-start)/2;
        mergeSortAlgo(input_vals,start,mid);
        mergeSortAlgo(input_vals, mid+1, end);
        merge(input_vals, start, end, mid);
    }

    private void merge(List<Integer> input_vals, int start, int end, int mid) throws ExecutionException, InterruptedException {
        List<Integer> left_ip = new ArrayList<>();
        for(int i=start; i<=mid; i++){
            left_ip.add(input_vals.get(i));
        }
        ExecutorService service = Executors.newCachedThreadPool();
        Future<List<Integer>> left1 = service.submit(new Sorter(left_ip));
        List<Integer> right_ip = new ArrayList<>();
        for(int i=mid+1; i<=end; i++){
            right_ip.add(input_vals.get(i));
        }
        Future<List<Integer>> right1 = service.submit(new Sorter(right_ip));
        List<Integer> left = left1.get();
        List<Integer> right = right1.get();

        int i = 0; int j=0; int index = start;
        while(i < left.size() && j < right.size()){
            if(left.get(i) <= right.get(i)){
                sorted_vals.set(index, left.get(i));
                index++; i++;
            }
            else{
                sorted_vals.set(index, right.get(j));
                index++; j++;
            }
        }
        while(i < left.size()){
           sorted_vals.set(index,left.get(i));
           index++; i++;
        }
        while(j < right.size()){
            sorted_vals.set(index,right.get(j));
            index++; j++;
        }
    }
}

