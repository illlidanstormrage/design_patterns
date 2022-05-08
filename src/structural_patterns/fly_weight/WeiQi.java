package structural_patterns.fly_weight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class WeiQi {
    public static void main(String[] args) {
        new ChessBoard();
    }
}

// 棋盘对象
class ChessBoard extends MouseAdapter{
    WeiQiFactory wf;
    JFrame f;
    Graphics g;
    JRadioButton wz;
    JRadioButton bz;
    private final int x = 50;
    private final int y = 50;
    private final int w = 40; //小方格的宽度和高度
    private final int rw = 400; //棋盘的宽度和高度

    ChessBoard() {
        wf = new WeiQiFactory();
        f = new JFrame("围棋");
        f.setBounds(100, 100, 500, 550);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel southJP = new JPanel();
        f.add("South", southJP);
        wz = new JRadioButton("白子");
        bz = new JRadioButton("黑子", true);
        ButtonGroup group = new ButtonGroup();
        group.add(wz);
        group.add(bz);
        southJP.add(wz);
        southJP.add(bz);
        JPanel centerJP = new JPanel();
        centerJP.setLayout(null);
        centerJP.setSize(500, 500);
        centerJP.addMouseListener(this);
        f.add("Center", centerJP);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g = centerJP.getGraphics();
        g.setColor(Color.BLUE);
        g.drawRect(x, y, rw, rw);
        for(int i=0; i<10; i++){
            g.drawLine(x+(i*w), y, x+(i*w), y+rw);
            g.drawLine(x, y+(i*w), x+rw, y+(i*w));
        }
    }

    public void mouseClicked(MouseEvent e) {
        Point point = new Point(e.getX()-15, e.getY()-15);
        if (wz.isSelected()) {
            ChessPieces c1 = wf.getChessPieces("w");
            c1.downPieces(g, point);
        } else if (bz.isSelected()) {
            ChessPieces c2 = wf.getChessPieces("b");
            c2.downPieces(g, point);
        }
    }
}

// 抽象享元角色：棋子
interface ChessPieces {
    void downPieces(Graphics g, Point point);
}

// 具体享元角色：白子
class WhitePieces implements ChessPieces {

    @Override
    public void downPieces(Graphics g, Point point) {
        g.setColor(Color.WHITE);
        g.fillOval(point.x, point.y, 30, 30);
    }
}

// 具体享元角色：黑子
class BlackPieces implements ChessPieces {

    @Override
    public void downPieces(Graphics g, Point point) {
        g.setColor(Color.BLACK);
        g.fillOval(point.x, point.y, 30, 30);
    }
}

// 围棋工厂，享元工厂角色
class WeiQiFactory {
    private final ArrayList<ChessPieces> qz;

    public WeiQiFactory() {
        qz = new ArrayList<ChessPieces>();
        ChessPieces w = new WhitePieces();
        qz.add(w);
        ChessPieces b = new BlackPieces();
        qz.add(b);
    }

    public ChessPieces getChessPieces(String type){
        if(type.equalsIgnoreCase("w")){
            return (WhitePieces) qz.get(0);
        }else if(type.equalsIgnoreCase("b")){
            return (BlackPieces) qz.get(1);
        }else{
            return null;
        }
    }
}