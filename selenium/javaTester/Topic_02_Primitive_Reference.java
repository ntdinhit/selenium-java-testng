package javaTester;

public class Topic_02_Primitive_Reference {
    int x;
    public static void main(String[] args) {
        int x = 42;
        int y= x;
        System.out.println("X = " + x); //42
        System.out.println("Y = " + y); //42

        x = 50;
        System.out.println("X = " + x); //50
        System.out.println("Y = " + y); //42

        //Class
        //Instance 1
        Topic_02_Primitive_Reference t1 = new Topic_02_Primitive_Reference();
        t1.x = 42;
        System.out.println(t1.x);

        //Instance 2
        Topic_02_Primitive_Reference t2 = t1;
        System.out.println(t2.x);

        t1.x = 100;
        System.out.println(t1.x);
        System.out.println(t2.x);
    }
}
