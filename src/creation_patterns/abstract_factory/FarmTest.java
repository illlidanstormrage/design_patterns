package creation_patterns.abstract_factory;

import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.*;
import java.io.*;
import java.lang.reflect.Constructor;

public class FarmTest {
    public static void main(String[] args) {
        try{
            Animal animal;
            Plant plant;
            Farm farm = (Farm) ReadXML.getObject();
            assert farm != null;
            animal = farm.newAnimal();
            plant = farm.newPlant();
            animal.show();
            plant.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

interface Animal{
    void show();
}

class Cattle implements Animal{

    @Override
    public void show() {
        System.out.println("this is Cattle");
    }
}

class Horse implements Animal{

    @Override
    public void show() {
        System.out.println("this is Horse");
    }
}
interface Plant{
    void show();
}

class Fruit implements Plant{

    @Override
    public void show() {
        System.out.println("this is Fruit");
    }
}

class Vegetables implements Plant{

    @Override
    public void show() {
        System.out.println("this is Vegetable");
    }
}

interface Farm {
    Animal newAnimal();
    Plant newPlant();
}

// 具体农场
class SGFarm implements Farm{

    @Override
    public Animal newAnimal() {
        System.out.println("new Cattle");
        return new Cattle();
    }

    @Override
    public Plant newPlant() {
        System.out.println("new Vegetable!");
        return new Vegetables();
    }
}

// 具体农场
class SRFarm implements Farm{

    @Override
    public Animal newAnimal() {
        System.out.println("new Horse");
        return new Horse();
    }

    @Override
    public Plant newPlant() {
        System.out.println("new Vegetable");
        return new Vegetables();
    }
}

class ReadXML{
    public static @Nullable Object getObject(){
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(new File("src/creation_patterns/abstract_factory/FarmTestConfig.xml"));
            NodeList nodeList = doc.getElementsByTagName("className");
            Node classNode = nodeList.item(0).getFirstChild();
            String className = "creation_patterns.abstract_factory." + classNode.getNodeValue();
            System.out.println("new class name: " + className);
            Class<?> c = Class.forName(className);
            Constructor<?> con = c.getDeclaredConstructor();
            return (Farm) con.newInstance();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}