package structural_patterns.composite;

import java.util.ArrayList;

public class ShoppingTest {
    public static void main(String[] args) {
        float s = 0;
        Bags bigBag = new Bags("big bag");
        Bags mediumBag = new Bags("medium bag");
        Bags smallRedBag = new Bags("small red bag");
        Bags smallWhiteBag = new Bags("small white bag");
        smallRedBag.add(new Goods("specialty", 2, 7.9f));
        smallRedBag.add(new Goods("map", 1, 9.9f));
        smallWhiteBag.add(new Goods("xiangxiang", 2, 68));
        smallWhiteBag.add(new Goods("red tea", 3, 180));

        mediumBag.add(new Goods("china", 1, 380));
        mediumBag.add(smallRedBag);

        bigBag.add(new Goods("sports shoe", 1, 198));
        bigBag.add(mediumBag);
        bigBag.add(smallWhiteBag);

        bigBag.show();
    }
}

// 抽象构件：物品
interface Articles {

    float calculation();

    void show();
}

// 树叶构建：商品
class Goods implements Articles {
    private final String name;
    private final int quantity;
    private final float unitPrice;

    Goods(String name, int quantity, float unitPrice){
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public float calculation() {
        return unitPrice * quantity;
    }

    @Override
    public void show() {
        System.out.println(name + "(quantity: " + quantity + ", unitPrice: " + unitPrice + " RMB)");
    }
}

// 树枝构建：袋子
class Bags implements Articles {
    private final String name;
    private ArrayList<Articles> bags = new ArrayList<>();

    public Bags(String name){
        this.name = name;
    }

    public void add(Articles article) {
        bags.add(article);
    }

    public void remove(Articles article) {
        bags.remove(article);
    }

    public Articles getChild(int i) {
        return bags.get(i);
    }

    @Override
    public float calculation() {
        float sum = 0;
        for(Articles article : bags) {
            sum += article.calculation();
        }
        return sum;
    }

    @Override
    public void show() {
        for(Articles article : bags){
            article.show();
        }
    }
}