package creation_patterns.prototype;

class MonkeyKingRealize implements Cloneable{
    // 孙悟空名字
    private static String name;
    private static final long serialVersionUID = 10086;

    public MonkeyKingRealize() {
        System.out.println("原型创建完毕");
    }

    @Override
    public MonkeyKingRealize clone() {
        MonkeyKingRealize mk = null;
        try {
            mk = (MonkeyKingRealize) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝悟空失败！");
        }
        return mk;
    }
}

public class MonkeyKing {
    public static void main(String[] args) {
        MonkeyKingRealize monkeyKing = new MonkeyKingRealize();
        MonkeyKingRealize obj1 = monkeyKing.clone();
        System.out.println("same?" + (monkeyKing == obj1));
    }
}
