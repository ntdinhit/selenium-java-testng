package javaTester;
import java.util.Random;
public class Topic_03_Random {
    public static void main (String[] args){
        Random rand = new Random();
        System.out.println(rand.nextBoolean());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextFloat());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextLong());
        System.out.println("donaldtrump" + new Random().nextInt(9999) + "@gmail.net");
        System.out.println("donaldtrump" + rand.nextInt(9999) + "@gmail.net");
    }
}