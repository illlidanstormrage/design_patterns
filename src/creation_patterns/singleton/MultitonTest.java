package creation_patterns.singleton;

import java.util.ArrayList;
import java.util.Random;

class Multiton {
    private static final ArrayList<Multiton> list = new ArrayList<>();
    private static final int size = 2;

    static {
        for(int i=0; i<size; i++){
            list.add(new Multiton());
        }
    }

    // private构造函数防止外部构建
    private Multiton(){}

    public static synchronized Multiton getInstance(){
        Random random = new Random();
        int current = random.nextInt(size);
        return list.get(current);
    }

    public static synchronized Multiton getInstance(int index) {
        return list.get(index);
    }
}

public class MultitonTest {
    public static void main(String[] args) {
        Multiton instance1 = Multiton.getInstance();
        Multiton instance2 = Multiton.getInstance();
        Multiton instance3 = Multiton.getInstance();
        System.out.println("1 and 2 same?" + (instance1 == instance2));
        System.out.println("2 and 3 same?" + (instance2 == instance3));
    }
}
