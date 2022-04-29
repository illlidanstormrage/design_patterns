package creation_patterns.prototype;

// 具体原型类
class Realizetype implements Cloneable{
    Realizetype(){}

    @Override
    public Realizetype clone() {
        try {
            return (Realizetype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype obj1 = new Realizetype();
        Realizetype obj2 = (Realizetype) obj1.clone();
        System.out.println("obj1==obj2?" + (obj1 == obj2));
    }
}
