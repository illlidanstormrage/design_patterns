package structural_patterns.bridge;

// 客户类
public class BagManage {
    public static void main(String[] args) {
        Color color = new Yellow();
        Bag bag = new HandBag(color);
        String name = bag.getName();
        System.out.println(name);
    }
}

// 颜色接口
interface Color {
    // 获取颜色
    String getColor();
}

// 抽象化包
abstract class Bag{
    protected Color color;

    protected Bag(Color color){
        this.color = color;
    }

    public abstract String getName();
}

// 实现颜色方法
class Yellow implements Color{

    @Override
    public String getColor() {
        return "yellow";
    }
}

// 实现颜色
class Red implements Color{
    @Override
    public String getColor() {
        return "red";
    }
}

// 扩展包类型
class HandBag extends Bag{
    protected HandBag(Color color) {
        super(color);
    }

    @Override
    public String getName() {
        return color.getColor() + " HandBag";
    }
}

// 扩展包类型
class Wallet extends Bag{
    protected Wallet(Color color) {
        super(color);
    }

    @Override
    public String getName() {
        return color.getColor() + " Wallet";
    }
}

