package creation_patterns.builder;

import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Constructor;

public class ParlourDecorator {
    public static void main(String[] args) {
        try {
            Decorator d = (Decorator) ReadXML.getObject();
            ProjectManager m = new ProjectManager(d);
            Parlour p = m.decorate();
            p.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

// 产品角色：定义多个组成部件
class Parlour{
    private String wall;
    private String TV;
    private String sofa;

    public void setWall(String wall){
        this.wall = wall;
    }

    public void setTV(String TV){
        this.TV = TV;
    }

    public void setSofa(String sofa){
        this.sofa = sofa;
    }

    public void show(){
        String parlour = wall + " " + TV + " " + sofa;
        System.out.println(parlour);
    }
}

// 抽象建造者：包含创建产品各个子部件的抽象方法
abstract class Decorator{
    protected Parlour product = new Parlour();
    public void buildWall(){}
    public void buildTV(){}
    public void buildSofa(){}

    public Parlour getResult(){
        return this.product;
    }
}

// 具体建造者1：实现了抽象建造者接口
class ConcreteDecorator1 extends Decorator{
    @Override
    public void buildWall() {
        System.out.println("worker1 is building wall");
        product.setWall("wall1");
    }

    @Override
    public void buildTV() {
        System.out.println("worker1 is building TV");
        product.setTV("TV1");
    }

    @Override
    public void buildSofa() {
        System.out.println("worker1 is building sofa");
        product.setSofa("sofa1");
    }
}

// 具体建造者2：实现抽象建造者接口
class ConcreteDecorator2 extends Decorator{
    @Override
    public void buildWall() {
        System.out.println("worker2 is building wall");
        product.setWall("wall2");
    }

    @Override
    public void buildTV() {
        System.out.println("worker2 is building TV");
        product.setTV("TV2");
    }

    @Override
    public void buildSofa() {
        System.out.println("worker2 is building sofa");
        product.setSofa("sofa2");
    }
}

// 指挥者：调用建造者中的方法完成复杂对象的创建
class ProjectManager{
    private Decorator builder;

    public ProjectManager(){}

    public ProjectManager(Decorator builder){
        this.builder = builder;
    }

    public Parlour decorate(){
        builder.buildWall();
        builder.buildTV();
        builder.buildSofa();
        return builder.getResult();
    }
}

class ReadXML{
    public static @Nullable Object getObject(){
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(new File("src/creation_patterns/builder/ParlourDecoratorConfig.xml"));
            NodeList nodeList = doc.getElementsByTagName("className");
            Node classNode = nodeList.item(0).getFirstChild();
            String className = "creation_patterns.builder." + classNode.getNodeValue();
            System.out.println("new class name: " + className);
            Class<?> c = Class.forName(className);
            Constructor<?> con = c.getDeclaredConstructor();
            return con.newInstance();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}