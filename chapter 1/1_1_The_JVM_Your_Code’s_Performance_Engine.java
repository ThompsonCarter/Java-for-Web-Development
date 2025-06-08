
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Example code for JVM performance engine
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
    }
}