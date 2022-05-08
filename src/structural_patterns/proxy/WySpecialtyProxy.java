package structural_patterns.proxy;

import javax.swing.*;
import java.awt.*;

public class WySpecialtyProxy {
    public static void main(String[] args) {
        SgProxy sgProxy = new SgProxy();
        sgProxy.display();
    }
}

// 抽象主题：特产
interface Specialty{
    void display();
}

// 真实主题：婺源特产
class WySpecialty extends JFrame implements Specialty{
    private static final long serialVersionUID = 1L;
    public WySpecialty() throws HeadlessException {
        super("test");
        this.setLayout(new GridLayout(1, 1));
        JLabel l1 = new JLabel(new ImageIcon("src/structural_patterns/proxy/WuyuanSpecialty.jpg"));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void display() {
        this.setVisible(true);
    }
}

// 代理：韶关代理
class SgProxy implements Specialty{
    private WySpecialty realSubject = new WySpecialty();

    @Override
    public void display() {
        preRequest();
        realSubject.display();
        postRequest();
    }

    private void preRequest(){
        System.out.println("proxy begin");
    }

    private void postRequest(){
        System.out.println("proxy finished");
    }
}