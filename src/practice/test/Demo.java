package practice.test;

/**
 * @Classname Demo
 * @Description 牛客上一个题目的测试代码
 * @Date 10/12/2019 9:19 AM
 * @Created by MichaelCS
 */
public class Demo {
    class Super {
        int flag = 1;

        Super() {
            test();
        }

        void test() {
            System.out.println("Super.test() flag=" + flag);
        }
    }

    class Sub extends Super {
        Sub(int i) {
            flag = i;
            System.out.println("Sub.Sub()flag=" + flag);
        }

        void test() {
            System.out.println("Sub.test()flag=" + flag);
        }
    }

    public static void main(String[] args) {
        new Demo().new Sub(5);
        // Supper.test() flag= 1;
        //
    }
}