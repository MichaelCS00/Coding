package practice.test;

import java.util.Map;

/**
 * @Classname StringTest
 * @Description 测试父子类的加载顺序,及各个代码块执行时间
 * @Date 2019/9/25 14:27
 * @Created by MichaelCS
 */


class A{

    //private static A a = new A();

    static {
        System.out.println("A static block");
    }

    {
        System.out.println("A default code block");
    }

    public A(){
        System.out.println("A default constructor");
    }
    public A(int a){
        System.out.println(a);
    }
}
class B extends A{

    //private static B a = new B();

    static {
        System.out.println("B static block");
    }

    {
        System.out.println("B default code block");
    }

    public B(){
        super();
        System.out.println("B default constructor");

    }
    public B(int a){
        super(a);
        System.out.println(2);
    }
}
class SuperAndSubTest {
    public static void main(String[] a){
        new B();
    }
}
