在有些系统中，为了节省内存资源、保证数据内容的一致性，对某些类要求只能创建一个实例，这就是所谓的单例模式。

## 单例模式的定义与特点
单例（Singleton）模式的定义：指一个类只有一个实例，且该类能自行创建这个实例的一种模式。例如，Windows 中只能打开一个任务管理器，这样可以避免因打开多个任务管理器窗口而造成内存资源的浪费，或出现各个窗口显示内容的不一致等错误。

在计算机系统中，还有 Windows 的回收站、操作系统中的文件系统、多线程中的线程池、显卡的驱动程序对象、打印机的后台处理服务、应用程序的日志对象、数据库的连接池、网站的计数器、Web 应用的配置对象、应用程序中的对话框、系统中的缓存等常常被设计成单例。

单例模式在现实生活中的应用也非常广泛，例如公司 CEO、部门经理等都属于单例模型。J2EE 标准中的 ServletContext 和 ServletContextConfig、Spring 框架应用中的 ApplicationContext、数据库中的连接池等也都是单例模式。

单例模式有 3 个特点：
- 单例类只有一个实例对象；
- 该单例对象必须由单例类自行创建；
- 单例类对外提供一个访问该单例的全局访问点。

## 单例模式的优点和缺点
单例模式的优点：
- 单例模式可以保证内存里只有一个实例，减少了内存的开销。
- 可以避免对资源的多重占用。
- 单例模式设置全局访问点，可以优化和共享资源的访问。

单例模式的缺点：
- 单例模式一般没有接口，扩展困难。如果要扩展，则除了修改原来的代码，没有第二种途径，违背开闭原则。
- 在并发测试中，单例模式不利于代码调试。在调试过程中，如果单例中的代码没有执行完，也不能模拟生成一个新的对象。
- 单例模式的功能代码通常写在一个类中，如果功能设计不合理，则很容易违背单一职责原则。

## 单例模式的应用场景
对于 Java 来说，单例模式可以保证在一个 JVM 中只存在单一实例。单例模式的应用场景主要有以下几个方面。
* 需要频繁创建的一些类，使用单例可以降低系统的内存压力，减少 GC。
* 某类只要求生成一个对象的时候，如一个班中的班长、每个人的身份证号等。
* 某些类创建实例时占用资源较多，或实例化耗时较长，且经常使用。
* 某类需要频繁实例化，而创建的对象又频繁被销毁的时候，如多线程的线程池、网络连接池等。
* 频繁访问数据库或文件的对象。
* 对于一些控制硬件级别的操作，或者从系统上来讲应当是单一控制逻辑的操作，如果有多个实例，则系统会完全乱套。
* 当对象需要被共享的场合。由于单例模式只允许创建一个对象，共享该对象可以节省内存，并加快对象访问速度。如 Web 中的配置对象、数据库的连接池等。

## 单例模式的结构
单例模式是设计模式中最简单的模式之一。通常，普通类的构造函数是公有的，外部类可以通过“new 构造函数()”来生成多个实例。但是，如果将类的构造函数设为私有的，外部类就无法调用该构造函数，也就无法生成多个实例。这时该类自身必须定义一个静态私有实例，并向外提供一个静态的公有函数用于创建或获取该静态私有实例。

![](structure.jpg)

## 单例模式的实现
**第一种：懒汉式单例**

该模式的特点是类加载时没有生成单例，只有当第一次调用 getInstance 方法的时候才创建这个单例，代码如下所示

```java
public class LazySingleton {
    private static volatile LazySingleton instance = null; //保证 instance 在所有线程中同步

    private LazySingleton(){}

    public static synchronized LazySingleton getInstance(){
        // getInstance方法前加同步
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

注意：如果编写的是多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，否则将存在线程非安全的问题。如果不删除这两个关键字就能保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点。

**第二种：饿汉式单例**

该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例就已经存在了。

```java
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    
    private HungrySingleton() {}
    
    public static HungrySingleton getInstance() {
        return instance;
    }
}
```

## 单例模式的示例

用懒汉式单例模式模拟产生美国当今总统对象

分析：在每一届任期内，美国的总统只有一个人

![](president.png)

该示例在 *[SingletonLazy.java](SingletonLazy.java)* 中实现

## 单例模式的扩展

单例模式可扩展为有限的多例（Multitcm）模式，这种模式可生成有限个实例并保存在 ArrayList 中，客户需要时可随机获取

![](multitcm_structure.png)

```java
class Multiton {
    private static final ArrayList<Multiton> list = new ArrayList<>();
    private static final int size = 2;

    static {
        for(int i=0; i<size; i++){
            list.add(new Multiton());
        }
    }

    // private构造函数防止外部构建
    private Multiton(){}

    public static synchronized Multiton getInstance(){
        Random random = new Random();
        int current = random.nextInt(size);
        return list.get(current);
    }

    public static synchronized Multiton getInstance(int index) {
        return list.get(index);
    }
}
```