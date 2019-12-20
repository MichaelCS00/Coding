package practice.design;

/**
 * @Classname Strategy
 * @Description TODO
 * @Date 12/15/2019 6:48 PM
 * @Created by MichaelCS
 */
public class Strategy {
    static private void test(Test test){
        test.doSomthing();
    }
    public static void main(String[] args){
        Test test = new Test2();
        test(test);
    }
}

interface Test{
    public void doSomthing();
}

class Test1 implements Test{
    @Override
    public void doSomthing() {
        System.out.println("Test1");
    }
}

class Test2 implements Test{
    @Override
    public void doSomthing() {
        System.out.println("Test2");
    }
}

class Test3 implements Test{
    @Override
    public void doSomthing() {
        System.out.println("Test3");
    }
}

class Test6 implements Test{
    @Override
    public void doSomthing() {
        System.out.println("Test6");
    }
}

class Test4 implements Test{
    @Override
    public void doSomthing() {
        System.out.println("Test4");
    }
}class Test5 implements Test{
    @Override
    public void doSomthing() {
        System.out.println("Test5");
    }
}