package creation_patterns.singleton;

import java.util.ArrayList;

class HungryMultiton {
    private static final ArrayList<HungryMultiton> list = new ArrayList<>();

    // private构造函数防止外部构建
    private HungryMultiton(){}

    private HungryMultiton(int n){
        for (int i = 0; i < n; i++) {
            list.add(new Multiton(i));
        }

    }

    public static HungryMultiton getRandomInstance() {

        return
    }
}

public class Multiton {
    public static void main(String[] args) {

    }
}
