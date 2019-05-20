
/* 这个类指定的方法就是提供给不同子类的“模板”，以便统一算法的策略，
 * 算法内的步骤切割得太细，在子类中实现过多的抽象方法会比较麻烦；
 * 切割得太粗，又出去了灵活性；
 * 故要视使用情况而定
 */
public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        /* 钩子是执行某个方法的条件，可以由子类指定这个条件，
         * 关键是：子类中不指定条件时，钩子会指定一个默认的条件，
         * 钩子可以改变算法的流程
         */
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /* 其中抽象方法具体的实现在子类中（类似于策略模式） */
    abstract void brew();
    abstract void addCondiments();

    final void boilWater() {
        System.out.println("Boiling water");
    }

    /* 不变的方法，不可以被子类重写，只能直接使用 */
    final void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /* 钩子：
     * 是一个开关，由使用者重新钩子来指定某些方法是否执行，
     * 钩子有一个默认的返回值
     */
    boolean customerWantsCondiments() {
        return true;
    }
}

/**
 * OO模板方法模式：
 * 在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。
 * 注：模板方法有很多具体实现，它们不一定和教科书上所讲的一致。
 */

/**
 * OO设计原则八：好莱坞原则——
 * （模板对子类说：）别调用我们，我们会调用你。
 * 模板是高层组件，它通过钩子决定在什么情况下调用哪一个方法（这个方法由低层组件来具体实现）；
 * 好莱坞原则使得客户仅依赖一个高层的模板方法类即可完成一整套流程，而不需要依赖更多的具体的低层子类。
 */

/**
 * 对比设计原则：
 * 策略模式：封装可互换的行为，然后使用委托来决定要采用哪一个行为；
 * 模板方法：子类决定如何实现算法中的步骤（通过钩子）；
 * 工厂方法：有子类决定实例化哪个具体类。
 */