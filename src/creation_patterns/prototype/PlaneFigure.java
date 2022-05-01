package creation_patterns.prototype;

import java.util.HashMap;
import java.util.Scanner;


interface Shape extends Cloneable {
/*
    Shape接口，继承Cloneable，实现克隆方法和计算面积方法
 */
    Object clone();
    void countArea();
}

class Circle implements Shape {

    @Override
    public Object clone() {
        Circle w = null;
        try{
            w = (Circle) super.clone();
        } catch(CloneNotSupportedException e){
            System.out.println("拷贝圆失败！");
        }
        return w;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("this is a circle, input r: ");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("the area of the circle is " + 3.1415 * r * r + '\n');
    }
}

class Square implements Shape {

    @Override
    public Object clone() {
        Square square = null;
        try {
            square = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝正方形失败！");
        }
        return square;
    }

    @Override
    public void countArea() {
        int width = 0;
        System.out.println("this is a square, input width:");
        Scanner input = new Scanner(System.in);
        width = input.nextInt();
        System.out.println("the area of the square is " + width * width + '\n');
    }
}

class ProtoType {
    /*
        图形原型
     */
    private HashMap<String, Shape> hm = new HashMap<String, Shape>();

    public ProtoType(){
        hm.put("Circle", new Circle());
        hm.put("Square", new Square());
    }

    public void addShape(String key, Shape obj){
        hm.put(key, obj);
    }

    public Shape getShape(String key) {
        Shape temp = hm.get(key);
        return (Shape)temp;
    }
}

public class PlaneFigure {
    public static void main(String[] args) {
        ProtoType protoType = new ProtoType();
        Shape circle = (Circle) protoType.getShape("Circle");
        circle.countArea();
        Shape square = (Square) protoType.getShape("Square");
        square.countArea();
    }
}
