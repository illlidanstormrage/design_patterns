# 设计模式分类
## 1、根据目的划分
- **创建型模式：** 用于描述“怎样创建对象”，它的主要特点是“将对象的创建与使用分离”。GoF 中提供了单例、原型、工厂方法、抽象工厂、建造者等 5 种创建型模式。
- **结构型模式：** 用于描述如何将类或对象按某种布局组成更大的结构，GoF 中提供了代理、适配器、桥接、装饰、外观、享元、组合等 7 种结构型模式。
- **行为型模式：** 用于描述类或对象之间怎样相互协作共同完成单个对象都无法单独完成的任务，以及怎样分配职责。GoF 中提供了模板方法、策略、命令、职责链、状态、观察者、中介者、迭代器、访问者、备忘录、解释器等 11 种行为型模式。

## 2、根据作用范围来分
根据模式是主要用于类上还是主要用于对象上来分，这种方式可分为类模式和对象模式两种。
类模式：用于处理类与子类之间的关系，这些关系通过继承来建立，是静态的，在编译时刻便确定下来了。GoF中的工厂方法、（类）适配器、模板方法、解释器属于该模式。
对象模式：用于处理对象之间的关系，这些关系可以通过组合或聚合来实现，在运行时刻是可以变化的，更具动态性。GoF 中除了以上 4 种，其他的都是对象模式。

| 范围\目的 |     创建型模式      | 结构型模式                     | 行为型模式                            |
|:-----:|:--------------:|---------------------------|----------------------------------|
|  类模式  |      工厂方法      | （类）适配器                    | 模板方法、解释器                         |
| 对象模式  | 单例、原型、抽象工厂、建造者 | 代理、（对象）适配器、桥接、装饰、外观、享元、组合 | 策略、命令、职责链、状态、观察者、中介者、迭代器、访问录、备忘录 |

## 3、GoF的23种设计模式的功能
1. 单例（Singleton）模式：某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式。
2. 原型（Prototype）模式：将一个对象作为原型，通过对其进行复制而克隆出多个和原型类似的新实例。
3. 工厂方法（Factory Method）模式：定义一个用于创建产品的接口，由子类决定生产什么产品。
4. 抽象工厂（AbstractFactory）模式：提供一个创建产品族的接口，其每个子类可以生产一系列相关的产品。
5. 建造者（Builder）模式：将一个复杂对象分解成多个相对简单的部分，然后根据不同需要分别创建它们，最后构建成该复杂对象。
6. 代理（Proxy）模式：为某对象提供一种代理以控制对该对象的访问。即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。
7. 适配器（Adapter）模式：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
8. 桥接（Bridge）模式：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。
9. 装饰（Decorator）模式：动态的给对象增加一些职责，即增加其额外的功能。
10. 外观（Facade）模式：为多个复杂的子系统提供一个一致的接口，使这些子系统更加容易被访问。
11. 享元（Flyweight）模式：运用共享技术来有效地支持大量细粒度对象的复用。
12. 组合（Composite）模式：将对象组合成树状层次结构，使用户对单个对象和组合对象具有一致的访问性。
13. 模板方法（TemplateMethod）模式：定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。
14. 策略（Strategy）模式：定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的改变不会影响使用算法的客户。
15. 命令（Command）模式：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。
16. 职责链（Chain of Responsibility）模式：把请求从链中的一个对象传到下一个对象，直到请求被响应为止。通过这种方式去除对象之间的耦合。
17. 状态（State）模式：允许一个对象在其内部状态发生改变时改变其行为能力。
18. 观察者（Observer）模式：多个对象间存在一对多关系，当一个对象发生改变时，把这种改变通知给其他多个对象，从而影响其他对象的行为。
19. 中介者（Mediator）模式：定义一个中介对象来简化原有对象之间的交互关系，降低系统中对象间的耦合度，使原有对象之间不必相互了解。
20. 迭代器（Iterator）模式：提供一种方法来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示。
21. 访问者（Visitor）模式：在不改变集合元素的前提下，为一个集合中的每个元素提供多种访问方式，即每个元素有多个访问者对象访问。
22. 备忘录（Memento）模式：在不破坏封装性的前提下，获取并保存一个对象的内部状态，以便以后恢复它。
23. 解释器（Interpreter）模式：提供如何定义语言的文法，以及对语言句子的解释方法，即解释器。

# UML统一建模语言
## 基本构件
UML 建模的核心是模型，模型是现实的简化、真实系统的抽象。UML 提供了系统的设计蓝图。当给软件系统建模时，需要采用通用的符号语言，这种描述模型所使用的语言被称为建模语言。在 UML 中，所有的描述由事物、关系和图这些构件组成。下图完整地描述了所有构件的关系。
![](images/UML.png)

# 软件设计七大原则

| 设计原则 |               一句话归纳                |           目的           |
| :----: |:----------------------------------:|:----------------------:|
| 开闭原则 |            对扩展开放，对修改关闭             |       降低维护带来的新风险       |
| 依赖倒置原则 |         高层不应该依赖低层，要面向接口编程          |      更利于代码结构的升级扩展      |
| 单一职责原则 |          	一个类只干一件事，实现类要单一          |     便于理解，提高代码的可读性      |
| 接口隔离原则 |         	一个接口只干一件事，接口要精简单一         |      功能解耦，高聚合、低耦合      |
| 迪米特法则  | 	不该知道的不要知道，一个类应该保持对其它对象最少的了解，降低耦合度 | 只和朋友交流，不和陌生人说话，减少代码臃肿  |
| 里氏替换原则 | 不要破坏继承体系，子类重写方法功能发生改变，不应该影响父类方法的含义 |         防止继承泛滥         |
| 合成复用原则 |      尽量使用组合或者聚合关系实现代码复用，少使用继承      |        	降低代码耦合         |

# 总结

<table>
<thead>
  <tr>
    <th>分类</th>
    <th>设计模式</th>
    <th>简述</th>
    <th>一句话归纳</th>
    <th>目的</th>
    <th>生活案例</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td rowspan="4">创建型设计模式<br>（简单来说就是用来创建对象的）</td>
    <td>工厂模式（Factory Pattern）</td>
    <td>不同条件下创建不同实例</td>
    <td>产品标准化，生产更高效</td>
    <td>封装创建细节</td>
    <td>实体工厂</td>
  </tr>
  <tr>
    <td>单例模式（Singleton Pattern）</td>
    <td>保证一个类仅有一个实例，并且提供一个全局访问点</td>
    <td>世上只有一个我</td>
    <td>保证独一无二</td>
    <td>CEO</td>
  </tr>
  <tr>
    <td>原型模式（Prototype Pattern）</td>
    <td>通过拷贝原型创建新的对象</td>
    <td>拔一根猴毛，吹出千万个</td>
    <td>高效创建对象</td>
    <td>克隆</td>
  </tr>
  <tr>
    <td>建造者模式（Builder Pattern）</td>
    <td>用来创建复杂的复合对象</td>
    <td>高配中配和低配，想选哪配就哪配</td>
    <td>开放个性配置步骤</td>
    <td>选配</td>
  </tr>
  <tr>
    <td rowspan="7">结构型设计模式<br>（关注类和对象的组合）</td>
    <td>代理模式（Proxy Pattern）</td>
    <td>为其他对象提供一种代理以控制对这个对象的访问</td>
    <td>没有资源没时间，得找别人来帮忙</td>
    <td>增强职责</td>
    <td>媒婆</td>
  </tr>
  <tr>
    <td>外观模式（Facade Pattern）</td>
    <td>对外提供一个统一的接口用来访问子系统</td>
    <td>打开一扇门，通向全世界</td>
    <td>统一访问入口</td>
    <td>前台</td>
  </tr>
  <tr>
    <td>装饰器模式（Decorator Pattern）</td>
    <td>为对象添加新功能</td>
    <td>他大舅他二舅都是他舅</td>
    <td>灵活扩展、同宗同源</td>
    <td>煎饼</td>
  </tr>
  <tr>
    <td>享元模式（Flyweight Pattern）</td>
    <td>使用对象池来减少重复对象的创建</td>
    <td>优化资源配置，减少重复浪费</td>
    <td>共享资源池</td>
    <td>全国社保联网</td>
  </tr>
  <tr>
    <td>组合模式（Composite Pattern）</td>
    <td>将整体与局部（树形结构）进行递归组合，让客户端能够以一种的方式对其进行处理</td>
    <td>人在一起叫团伙，心在一起叫团队</td>
    <td>统一整体和个体</td>
    <td>组织架构树</td>
  </tr>
  <tr>
    <td>适配器模式（Adapter Pattern）</td>
    <td>将原来不兼容的两个类融合在一起</td>
    <td>万能充电器</td>
    <td>兼容转换</td>
    <td>电源适配</td>
  </tr>
  <tr>
    <td>桥接模式（Bridge Pattern）</td>
    <td>将两个能够独立变化的部分分离开来</td>
    <td>约定优于配置</td>
    <td>不允许用继承</td>
    <td>桥</td>
  </tr>
  <tr>
    <td rowspan="12">行为型设计模式<br>（关注对象之间的通信）</td>
    <td>模板模式（Template Pattern）</td>
    <td>定义一套流程模板，根据需要实现模板中的操作</td>
    <td>流程全部标准化，需要微调请覆盖</td>
    <td>逻辑复用</td>
    <td>把大象装进冰箱</td>
  </tr>
  <tr>
    <td>策略模式（Strategy Pattern）</td>
    <td>封装不同的算法，算法之间能互相替换</td>
    <td>条条大道通罗马，具体哪条你来定</td>
    <td>把选择权交给用户</td>
    <td>选择支付方式</td>
  </tr>
  <tr>
    <td>责任链模式（Chain of Responsibility Pattern）</td>
    <td>拦截的类都实现统一接口，每个接收者都包含对下一个接收者的引用。将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。</td>
    <td>各人自扫门前雪，莫管他们瓦上霜</td>
    <td>解耦处理逻辑</td>
    <td>踢皮球</td>
  </tr>
  <tr>
    <td>迭代器模式（Iterator Pattern）</td>
    <td>提供一种方法顺序访问一个聚合对象中的各个元素</td>
    <td>流水线上坐一天，每个包裹扫一遍</td>
    <td>统一对集合的访问方式</td>
    <td>逐个检票进站</td>
  </tr>
  <tr>
    <td>命令模式（Command Pattern）</td>
    <td>将请求封装成命令，并记录下来，能够撤销与重做</td>
    <td>运筹帷幄之中，决胜千里之外</td>
    <td>解耦请求和处理</td>
    <td>遥控器</td>
  </tr>
  <tr>
    <td>状态模式（State Pattern）</td>
    <td>根据不同的状态做出不同的行为</td>
    <td>状态驱动行为，行为决定状态</td>
    <td>绑定状态和行为</td>
    <td>订单状态跟踪</td>
  </tr>
  <tr>
    <td>备忘录模式（Memento Pattern）</td>
    <td>保存对象的状态，在需要时进行恢复</td>
    <td>失足不成千古恨，想重来时就重来</td>
    <td>备份、后悔机制</td>
    <td>草稿箱</td>
  </tr>
  <tr>
    <td>中介者模式（Mediator Pattern）</td>
    <td>将对象之间的通信关联关系封装到一个中介类中单独处理，从而使其耦合松散</td>
    <td>联系方式我给你，怎么搞定我不管</td>
    <td>统一管理网状资源</td>
    <td>朋友圈</td>
  </tr>
  <tr>
    <td>解释器模式（Interpreter Pattern）</td>
    <td>给定一个语言，定义它的语法表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子</td>
    <td>我想说”方言“，一切解释权都归我</td>
    <td>实现特定语法解析</td>
    <td>摩斯密码</td>
  </tr>
  <tr>
    <td>观察者模式（Observer Pattern）</td>
    <td>状态发生改变时通知观察者，一对多的关系</td>
    <td>到点就通知我</td>
    <td>解耦观察者与被观察者</td>
    <td>闹钟</td>
  </tr>
  <tr>
    <td>访问者模式（Visitor Pattern）</td>
    <td>稳定数据结构，定义新的操作行为</td>
    <td>横看成岭侧成峰，远近高低各不同</td>
    <td>解耦数据结构和数据操作</td>
    <td>KPI考核</td>
  </tr>
  <tr>
    <td>委派模式（Delegate Pattern）</td>
    <td>允许对象组合实现与继承相同的代码重用，负责任务的调用和分配</td>
    <td>这个需求很简单，怎么实现我不管</td>
    <td>只对结果负责</td>
    <td>授权委托书</td>
  </tr>
</tbody>
</table>

# TODO

**创建型模式**
- [x] [单例模式](src/creation_patterns/singleton/singleton.md)
- [x] [原型模式](src/creation_patterns/prototype/prototype.md)
- [x] [工厂方法](src/creation_patterns/factory_method/factory.md)
- [x] [抽象工厂](src/creation_patterns/factory_method/factory.md)
- [x] [建造者](src/creation_patterns/builder/builder.md)

**结构型模式**
- [x] [代理模式](src/structural_patterns/proxy/proxy.md)
- [x] [适配器模式](src/structural_patterns/adapter/adapter.md)
- [x] [桥接模式](src/structural_patterns/bridge/bridge.md)
- [x] [装饰模式](src/structural_patterns/decorator/decorator.md)
- [x] [外观模式](src/structural_patterns/facade/facade.md)
- [x] [享元模式](src/structural_patterns/fly_weight/flyweight.md)
- [x] [组合模式](src/structural_patterns/composite/composite.md)

**行为模式**
- [x] [模板方法](src/behavior_patterns/template/template.md)
- [x] [策略模式](src/behavior_patterns/strategy/strategy.md)
- [x] [命令模式](src/behavior_patterns/command/command.md)
- [x] [职责链模式](src/behavior_patterns/chain_of_responsibility/chain_of_responsibility.md)
- [ ] [状态模式](src/behavior_patterns/state/state.md)
- [ ] [观察者模式](src/behavior_patterns/observer/observer.md)
- [ ] [中介者模式](src/behavior_patterns/mediator/mediator.md)
- [ ] [迭代器模式](src/behavior_patterns/iterator/iterator.md)
- [ ] [访问者模式](src/behavior_patterns/visitor/visitor.md)
- [ ] [备忘录模式](src/behavior_patterns/memento/memento.md)
- [ ] [解释器模式](src/behavior_patterns/interpreter/interpreter.md)