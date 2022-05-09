package behavior_pattern.command;

public class BreakfastTest {
    public static void main(String[] args) {
        Breakfast food1 = new ChangFen();
        Breakfast food2 = new HunTun();
        Breakfast food3 = new HeFen();
        Waiter fwy = new Waiter();
        fwy.setChangFen(food1);//设置肠粉菜单
        fwy.setHunTun(food2);  //设置河粉菜单
        fwy.setHeFen(food3);   //设置馄饨菜单
        fwy.chooseChangFen();  //选择肠粉
        fwy.chooseHeFen();     //选择河粉
        fwy.chooseHunTun();    //选择馄饨
    }
}

interface Breakfast {
    void cooking();
}

class ChangFen implements Breakfast {
    private final ChangFenChef receiver;

    ChangFen() {
        receiver = new ChangFenChef();
    }

    @Override
    public void cooking() {
        receiver.cooking();
    }
}

class HunTun implements Breakfast {
    private final HunTunChef receiver;

    HunTun() {
        receiver = new HunTunChef();
    }

    @Override
    public void cooking() {
        receiver.cooking();
    }
}

class HeFen implements Breakfast {
    private final HeFenChef receiver;

    HeFen() {
        receiver = new HeFenChef();
    }

    @Override
    public void cooking() {
        receiver.cooking();
    }
}

class ChangFenChef {
    public void cooking(){
        System.out.println("肠粉");
    }
}

class HunTunChef {
    public void cooking() {
        System.out.println("馄饨");
    }
}

class HeFenChef {
    public void cooking() {
        System.out.println("河粉");
    }
}

class Waiter {
    private Breakfast changFen, hunTun, heFen;
    public void setChangFen(Breakfast f) {
        changFen = f;
    }
    public void setHunTun(Breakfast f) {
        hunTun = f;
    }
    public void setHeFen(Breakfast f) {
        heFen = f;
    }
    public void chooseChangFen() {
        changFen.cooking();
    }
    public void chooseHunTun() {
        hunTun.cooking();
    }
    public void chooseHeFen() {
        heFen.cooking();
    }
}


