package structural_patterns.decorator;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class MorriganAensland {
    public static void main(String[] args) {
        Morrigan original = new Original();
        Morrigan succubus = new Succubus(original);
        Morrigan girl = new Girl(original);
        original.display();
        succubus.display();
        girl.display();
    }
}

// 抽象构件角色
interface Morrigan{
    void display();
}


// 原身
class Original extends JFrame implements Morrigan {
    @Serial
    private static final long serialVersionUID = 1L;

    private String t = "Morrigan0.jpg";

    public Original(){
        super("《恶魔战士中的莫莉卡》");
    }

    public void setImage(String t){
        this.t = t;
    }

    public void display(){
        this.setLayout(new FlowLayout());
        JLabel l1 = new JLabel(new ImageIcon("src/structural_patterns/decorator/" + t));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}

// 抽象装饰角色：变形
class Changer implements Morrigan {
    Morrigan morrigan;

    public Changer(Morrigan morrigan){
        this.morrigan = morrigan;
    }

    @Override
    public void display() {
        morrigan.display();
    }
}

// 具体装饰角色：女妖
class Succubus extends Changer{

    public Succubus(Morrigan morrigan) {
        super(morrigan);
    }

    public void display(){
        setChanger();
        super.display();
    }

    public void setChanger(){
        ((Original) super.morrigan).setImage("Morrigan1.jpg");
    }
}

// 具体装饰角色：少女
class Girl extends Changer{

    public Girl(Morrigan morrigan) {
        super(morrigan);
    }

    public void display(){
        setChanger();
        super.display();
    }

    public void setChanger(){
        ((Original) super.morrigan).setImage("Morrigan2.jpg");
    }
}