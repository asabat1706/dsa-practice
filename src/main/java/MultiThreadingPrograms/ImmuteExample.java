package MultiThreadingPrograms;

public class ImmuteExample {
    public static void main(String[] args){
        String[] cls = {"c1","c2","c3"};
        String str = "ABC";
        Student s = new Student(str,1, cls);
        System.out.println(s.getName());
        str = "BCD";
        System.out.println(s.getName());
        System.out.println(s.getRoll());
        for(int i=0; i< s.getClasses().length; i++){
            System.out.print(s.getClasses()[i]+"  ");
        }
        cls = new String[]{"c4"};
        for(int i=0; i< s.getClasses().length; i++){
            System.out.print(s.getClasses()[i]+"  ");
        }
        s.getClasses()[0] = "s6";
        for(int i=0; i< s.getClasses().length; i++){
            System.out.print(s.getClasses()[i]+"  ");
        }
    }
}

final class Student{
    private String name;
    private int roll;
    private String[] classes;

    public Student(String name, int roll, String[] classes){
        this.name = name;
        this.roll = roll;
        int index=0;
        this.classes = new String[classes.length];
        for(String c : classes){
            this.classes[index++] =c;
        }
    }
    public final String getName(){
        return name;
    }
    public final int getRoll(){
        return roll;
    }
    public final String[] getClasses(){
        String[] objClasses = new String[this.classes.length];
        int index=0;
        for(String c : this.classes){
            objClasses[index++] = c;
        }
        return objClasses;
    }
}
