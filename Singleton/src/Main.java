import com.es2.singleton.Registry;

public class Main {
    public static void main(String args[]){
        Registry r1 = Registry.getInstance();
        Registry r2 = Registry.getInstance();

        r1.x += 10;

        System.out.println("Value of r1: " + r1.x);
        System.out.println("Value of r2: " + r2.x);
    }
}
