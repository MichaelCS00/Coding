package practice.test;

/**
 * @Classname IntegerTest
 * @Description Integer 如果表示范围为 -128 —— 127 不会创建对象，表示范围超出这个范围时才会创建对象！！！
 * @Date 10/6/2019 11:06 AM
 * @Created by MichaelCS
 */
public class IntegerTest {

    private static class Test{
        int a;
        void setA(int a){
            this.a = a;
        }
    }

    Integer integera = 1;

    private boolean IntegerFunc(Test test){
        integera++;
//        System.out.println(integerArray.equals(integerArray));
//        System.out.println(System.identityHashCode(integerArray));
        test.setA(2);
        return true;
    }

    private boolean StringFunc(String s){
        s = new String("changed");
        return true;
    }

    public static void main(String[] args){


        Integer integer = 12223;
        System.out.println(System.identityHashCode(integer));
        String s = new String("origin");
        Test test = new Test();
        test.a = 1;

        IntegerTest referenceTest = new IntegerTest();

        // 测试新建类引用
        referenceTest.IntegerFunc(test);
        System.out.println(test.a);

//        // 测试Integer 是否会被修改
//        referenceTest.IntegerFunc(integerArray);
//        System.out.println(integerArray);

//        // 测试String是否会被修改
//        referenceTest.StringFunc(s);
//        System.out.println(s);

        /**
         * 直接赋值会调用
         */
        Integer a = 12;
        Integer b = 12;

        System.out.println(a==b);
        System.out.println(a.equals(b));

        /**
         * Integer 在超出 -128-127 范围时才会新建对象
         */
        Integer c = 128;
        Integer d = 128;

        System.out.println(c==d);
        System.out.println(c.equals(d));
    }
}


