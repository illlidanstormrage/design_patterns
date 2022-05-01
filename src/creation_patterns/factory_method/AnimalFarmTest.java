package creation_patterns.factory_method;

import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Constructor;


public class AnimalFarmTest {
    public static void main(String[] args) {
        try {
            Animal animal;
            AnimalFarm animalFarm;
            animalFarm = (AnimalFarm) ReadXML.getObject();
            assert animalFarm != null;
            animal = (Animal) animalFarm.newAnimal();
            animal.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

// 抽象产品：动物
interface Animal {
    void show();
}

// 具体产品：马
class Horse implements Animal {

    @Override
    public void show() {
        System.out.println("this is Horse");
    }
}

// 具体产品：牛
class Cattle implements Animal{

    @Override
    public void show() {
        System.out.println("this is Cattle");
    }
}

//抽象工厂：畜牧场
interface AnimalFarm {
    Animal newAnimal();
}

// 具体工厂：养马场
class HorseFarm implements AnimalFarm {

    @Override
    public Animal newAnimal() {
        System.out.println("新马出生");
        return new Horse();
    }
}

// 具体工厂：养牛场
class CattleFarm implements AnimalFarm {

    @Override
    public Animal newAnimal() {
        System.out.println("新牛出生");
        return (Animal) new Cattle();
    }
}

class ReadXML {
    public static @Nullable Object getObject(){
        try{
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/creation_patterns/factory_method/AnimalFarmTestConfig.xml"));
            NodeList nodeList = doc.getElementsByTagName("className");
            Node classNode = nodeList.item(0).getFirstChild();
            String cName = "creation_patterns.factory_method." + classNode.getNodeValue();
            System.out.println("new class name: " + cName);
            Class<?> c = Class.forName(cName);
            Constructor<?> con = c.getDeclaredConstructor();
            return (AnimalFarm) con.newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

