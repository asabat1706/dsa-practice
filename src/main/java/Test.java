import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Singleton
{
    private static Singleton obj = getInstance();

    private Singleton() {}

    public static Singleton getInstance()
    {
        return obj;
    }
}
public class Test{
    public static void main(String[] args)throws IOException {
//        Singleton s = new Singleton();
        String s1 = new String("abc");
        String s2 = "abc";
        System.out.println(s1==s2);
        LinkedList<String> list = new LinkedList<>();
        list.addLast("B");
        list.addLast("B");
        list.remove("B");
        System.out.println(list);
//        throw new IOException("ABC");

        TreeMap<Integer, String> t = new TreeMap<>((t1,t2)->t1>t2?-1:1);
        t.put(10,"A");
        t.put(20,"B");
        t.put(30,"C");
        System.out.println(t);
        t.entrySet().stream().forEach(System.out::println);

        System.out.println((26&15) +"  "+(26%16));


        List<Integer> l = Arrays.asList(1,2,3,4,5,6);
        Consumer<List<Integer>> modify = l1->{
            for(int i=0; i<l1.size(); i++){
                l1.set(i,l1.get(i)*2);
            }
        };
        Supplier<Integer> rand = ()->{
            Random r = new Random();
            return r.nextInt();
        };
        Consumer<List<Integer>> printing = l1 ->{
            l1.forEach(System.out::println);
        };
        modify.andThen(printing).accept(l);

        List<String> ls1 = new ArrayList<>();
        ls1.add("Add");


    }
}