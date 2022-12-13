package MultiThreadingPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ExecutorDemo {
    public static void main(String[] args) throws Exception {
        List<Integer> input = new ArrayList<>();
        input.add(1); input.add(6); input.add(2); input.add(4);
        Sorter sorter = new Sorter(input);
        List<Integer> sorted = sorter.call();
        System.out.println(sorted);
    }

}
