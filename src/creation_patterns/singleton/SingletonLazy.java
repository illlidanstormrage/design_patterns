/*
用懒汉式单例模式模拟产生美国当今总统对象
 */

package creation_patterns.singleton;

public class SingletonLazy {
    public static void main(String[] args) {
        President president1 = President.getInstance();
        president1.getName();
        President president2 = President.getInstance();
        president2.getName();
        if(president2 == president1){
            System.out.println("we are the same instance!");
        }
        else{
            System.out.println("we are different!");
        }
    }
}

class President {
    private static volatile President instance = null;

    private String name;

    // private避免类在外部被实例化
    private President(){
        System.out.println("make a new president!");
        this.name = "Triumph";
    }

    public static synchronized President getInstance() {
        // 实例化方法前加同步
        if (instance == null){
            instance = new President();
        }
        else{
            System.out.println("president already exists!");
        }
        return instance;
    }

    public void getName() {
        System.out.println(name);
    }
}